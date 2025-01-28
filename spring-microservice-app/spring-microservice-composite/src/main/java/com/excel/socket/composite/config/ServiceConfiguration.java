package com.excel.socket.composite.config;

import com.excel.socket.core.repository.UserRepository;
import com.excel.socket.core.service.UserService;
import com.excel.socket.core.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ServiceConfiguration {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Bean
    @Qualifier("com.excel.socket.core.service.impl.UserServiceImpl")
    UserService userService() {
        return new UserServiceImpl(userRepository, passwordEncoder);
    }
}
