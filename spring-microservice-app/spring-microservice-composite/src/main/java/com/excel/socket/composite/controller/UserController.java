package com.excel.socket.composite.controller;


import com.excel.socket.core.dto.UserDto;
import com.excel.socket.core.service.UserService;
import com.excel.socket.core.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    ResponseEntity<String> registerUser(UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.registerUserDetail(userDto));
    }

}
