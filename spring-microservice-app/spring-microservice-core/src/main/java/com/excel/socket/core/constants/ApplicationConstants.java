package com.excel.socket.core.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationConstants {

    USER_REGISTERED("User Registered Successfully"),
    USER_ALREADY_REGISTERED("User is Already Registered"),
    USER_NOT_REGISTERED("User is not Registered"),
    USER_LOGIN_SUCCESSFUL("User Login Successful"),
    USER_LOGIN_FAILED("User Login Failed");

    private final String constant;

}
