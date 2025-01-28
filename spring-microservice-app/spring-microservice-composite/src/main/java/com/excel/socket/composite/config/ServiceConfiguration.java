package com.excel.socket.composite.config;

import com.excel.socket.core.service.UserService;
import com.excel.socket.core.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Qualifier("com.excel.socket.core.service.impl.UserServiceImpl")
    UserService userService() {
        return new UserServiceImpl();
    }
}
