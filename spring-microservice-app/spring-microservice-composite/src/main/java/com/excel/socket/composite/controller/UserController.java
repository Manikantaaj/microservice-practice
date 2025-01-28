package com.excel.socket.composite.controller;


import com.excel.socket.core.dto.UserDto;
import com.excel.socket.core.dto.UserLoginDto;
import com.excel.socket.core.response.Response;
import com.excel.socket.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    ResponseEntity<Response<String>> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(Response.<String>builder()
                .data(userService.registerUserDetail(userDto))
                .isError(false)
                .build());
    }

    @PostMapping("/login")
    ResponseEntity<Response<String>> loginUser(@RequestBody UserLoginDto userLoginDto) {
        return ResponseEntity.status(HttpStatus.OK).body(Response.<String>builder()
                .data(userService.loginUser(userLoginDto))
                .isError(false)
                .build());
    }

}
