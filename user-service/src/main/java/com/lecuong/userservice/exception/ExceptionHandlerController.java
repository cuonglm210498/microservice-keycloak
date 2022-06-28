package com.lecuong.userservice.exception;

import com.lecuong.userservice.modal.BaseResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerController {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse<ErrorCodeResponse>> handlerBusinessException(BusinessException e) {
        return new ResponseEntity<>(BaseResponse.ofFail(e), e.getErrorCodeResponse().getStatus());
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<BaseResponse<ErrorCodeResponse>> handlerAccessDeniedException(AccessDeniedException e) {
//        return new ResponseEntity<>(BaseResponse.ofFail(e), HttpStatus.FORBIDDEN);
//    }
}
