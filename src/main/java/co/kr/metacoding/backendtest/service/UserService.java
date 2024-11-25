package co.kr.metacoding.backendtest.service;

import co.kr.metacoding.backendtest.dto.UserDTO;
import co.kr.metacoding.backendtest.dto.UserRequest;
import co.kr.metacoding.backendtest.entity.User;
import co.kr.metacoding.backendtest.error.Exception404;
import co.kr.metacoding.backendtest.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    @Transactional
    public void postUser(UserRequest.PostDTO userRequestDto) {

        userRepo.postUser(userRequestDto.toEntity());

    }

    @Transactional
    public UserDTO findUser(int id) {
        Optional<User> u = userRepo.findByUserId(id);
        User userData = u.get();
        UserDTO userDto = new UserDTO(userData.getId(), userData.getName());
        return userDto;
    }

    @Transactional
    public void updateUserInfo(int id, UserRequest.UpdateDTO userRequestDto) {
        User user = userRepo.findByUserId(id)
                .orElseThrow(() -> new Exception404("오류발생: " + id));

        user.update(userRequestDto.getName());

    }
}
