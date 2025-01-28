package com.excel.socket.core.service;

import com.excel.socket.core.dto.UserDto;
import com.excel.socket.core.dto.UserLoginDto;

public interface UserService {

    String registerUserDetail(UserDto userDto);

    String loginUser(UserLoginDto userLoginDto);
}
