package com.lecuong.userservice.controller;

import com.lecuong.userservice.exception.ErrorCodeResponse;
import com.lecuong.userservice.modal.BaseResponse;
import org.springframework.http.ResponseEntity;

/**
 * author CuongLM
 */
public class BaseController {

    public ResponseEntity<BaseResponse<ErrorCodeResponse>> success() {
        return ResponseEntity.ok(BaseResponse.ofSuccess());
    }

    public <T> ResponseEntity<BaseResponse<T>> success(T data) {
        return ResponseEntity.ok(BaseResponse.ofSuccess(data));
    }
}
