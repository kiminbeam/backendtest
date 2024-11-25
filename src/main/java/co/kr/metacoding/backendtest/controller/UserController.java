package co.kr.metacoding.backendtest.controller;

import co.kr.metacoding.backendtest.dto.UserDTO;
import co.kr.metacoding.backendtest.dto.UserRequestDto;
import co.kr.metacoding.backendtest.entity.User;
import co.kr.metacoding.backendtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void postUser(@RequestBody UserRequestDto.PostDTO userRequestDto) {

        userService.postUser(userRequestDto);
    }


}
