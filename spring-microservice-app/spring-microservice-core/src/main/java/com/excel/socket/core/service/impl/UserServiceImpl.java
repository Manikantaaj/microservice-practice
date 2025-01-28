package com.excel.socket.core.service.impl;

import com.excel.socket.core.constants.ApplicationConstants;
import com.excel.socket.core.dto.UserDto;
import com.excel.socket.core.model.User;
import com.excel.socket.core.repository.UserRepository;
import com.excel.socket.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUserDetail(UserDto userDto) {
        userRepository.save(User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build());

        return ApplicationConstants.USER_REGISTERED.getConstant();
    }
}
