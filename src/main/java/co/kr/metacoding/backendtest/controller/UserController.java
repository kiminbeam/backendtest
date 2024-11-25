package co.kr.metacoding.backendtest.controller;

import co.kr.metacoding.backendtest.dto.UserDTO;
import co.kr.metacoding.backendtest.dto.UserRequest;
import co.kr.metacoding.backendtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void postUser(@RequestBody UserRequest.PostDTO userRequestDto) {

        userService.postUser(userRequestDto);

    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable int id) {
        System.out.println(userService.findUser(id));
        return userService.findUser(id);
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserRequest.UpdateDTO userUpdateDto) {
        System.out.println(userUpdateDto.getName());
        UserDTO updateUser = userService.updateUserInfo(id, userUpdateDto);

        return updateUser;
    }

}
