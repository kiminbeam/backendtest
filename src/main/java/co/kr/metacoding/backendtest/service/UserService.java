package co.kr.metacoding.backendtest.service;

import co.kr.metacoding.backendtest.dto.UserDTO;
import co.kr.metacoding.backendtest.dto.UserRequestDto;
import co.kr.metacoding.backendtest.entity.User;
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
    public void postUser(UserRequestDto.PostDTO userRequestDto) {


        userRepo.postUser(userRequestDto.toEntity());
    }
}
