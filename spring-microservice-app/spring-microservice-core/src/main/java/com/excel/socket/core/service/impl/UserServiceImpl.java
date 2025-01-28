package com.excel.socket.core.service.impl;

import com.excel.socket.core.constants.ApplicationConstants;
import com.excel.socket.core.dto.UserDto;
import com.excel.socket.core.dto.UserLoginDto;
import com.excel.socket.core.exception.UserException;
import com.excel.socket.core.model.User;
import com.excel.socket.core.repository.UserRepository;
import com.excel.socket.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerUserDetail(UserDto userDto) {
        Optional<User> optional = userRepository.findByEmail(userDto.getEmail());
        if (optional.isEmpty()) {
            userRepository.save(User.builder()
                    .name(userDto.getName())
                    .email(userDto.getEmail())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .build());
            return ApplicationConstants.USER_REGISTERED.getConstant();
        } else {
            throw new UserException(ApplicationConstants.USER_ALREADY_REGISTERED.getConstant());
        }
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        Optional<User> optional = userRepository.findByEmail(userLoginDto.getEmail());
        if (optional.isPresent()) {
            if (passwordEncoder.matches(userLoginDto.getPassword(), optional.get().getPassword())) {
                return ApplicationConstants.USER_LOGIN_SUCCESSFUL.getConstant();
            } else {
                return ApplicationConstants.USER_LOGIN_FAILED.getConstant();
            }
        } else {
            throw new UserException(ApplicationConstants.USER_NOT_REGISTERED.getConstant());
        }
    }
}
