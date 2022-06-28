package com.lecuong.userservice.modal.request.user;

import com.lecuong.userservice.modal.request.BaseRequest;
import lombok.Data;

/**
 * author CuongLM
 */
@Data
public class UserFilterRequest extends BaseRequest {

    private String userName;
    private String address;
    private String email;
    private String phone;
    private String createdBy;
    private Boolean status;
}
