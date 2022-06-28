package com.lecuong.userservice.modal.request.user;

import lombok.Data;

/**
 * author CuongLM
 */
@Data
public class UserAuthRequest {

    private String userName;
    private String password;
}
