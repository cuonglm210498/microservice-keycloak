package com.lecuong.userservice.modal;

import com.lecuong.userservice.exception.BusinessCodeResponse;
import com.lecuong.userservice.exception.BusinessException;
import com.lecuong.userservice.exception.ErrorCodeResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {

    private ErrorCodeResponse code;
    private T data;

    private BaseResponse(ErrorCodeResponse code) {
        this.code = code;
    }

    private BaseResponse(ErrorCodeResponse code, T data) {
        this.code = code;
        this.data = data;
    }

    public static BaseResponse<ErrorCodeResponse> ofSuccess() {
        return new BaseResponse<>(BusinessCodeResponse.SUCCESS);
    }

    public static <M> BaseResponse<M> ofSuccess(M data) {
        return new BaseResponse<>(BusinessCodeResponse.SUCCESS, data);
    }

    public static BaseResponse<ErrorCodeResponse> ofFail(BusinessException businessException) {
        return new BaseResponse<>(businessException.getErrorCodeResponse(), null);
    }

//    public static BaseResponse<ErrorCodeResponse> ofFail(AccessDeniedException accessDeniedException) {
//        return new BaseResponse<>(BusinessCodeResponse.FORBIDDEN, null);
//    }
}
