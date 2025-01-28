package com.excel.socket.core.service.impl;

import com.excel.socket.core.constants.ApplicationConstants;
import com.excel.socket.core.dto.UserDto;
import com.excel.socket.core.model.User;
import com.excel.socket.core.repository.UserRepository;
import com.excel.socket.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
