package com.lecuong.userservice.validate;

import com.lecuong.userservice.exception.BusinessCodeResponse;
import com.lecuong.userservice.exception.BusinessException;
import com.lecuong.userservice.modal.request.user.UserAuthRequest;
import com.lecuong.userservice.modal.request.user.UserCreateRequest;
import com.lecuong.userservice.service.UserService;
import com.lecuong.userservice.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author CuongLM
 */
@Component
public class UserValidator {

    @Autowired
    private UserService userService;

    public UserCreateRequest validateUserCreateRequest(UserCreateRequest userCreateRequest) {
        return Validator.data(userCreateRequest)
                .validate(UserCreateRequest::getUserName, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.USER_NAME_IS_EMPTY))
                .validate(UserCreateRequest::getUserName, userService::checkUserNameExist, () -> new BusinessException(BusinessCodeResponse.USER_NAME_AVAILABLE))
                .validate(UserCreateRequest::getPassword, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.PASSWORD_IS_EMPTY))
                .validate(UserCreateRequest::getPassword, StringUtils::verifyPassword, () -> new BusinessException(BusinessCodeResponse.PASSWORD_INVALIDATE))
                .validate(UserCreateRequest::getEmail, StringUtils::verifyEmail, () -> new BusinessException(BusinessCodeResponse.EMAIL_INVALIDATE))
                .validate(UserCreateRequest::getEmail, userService::checkEmailExist, () -> new BusinessException(BusinessCodeResponse.EMAIL_AVAILABLE))
                .validate(UserCreateRequest::getEmail, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.EMAIL_INVALIDATE))
                .validate(UserCreateRequest::getPhone, StringUtils::verifyPhoneNumber, () -> new BusinessException(BusinessCodeResponse.PHONE_NUMBER_INVALIDATE))
                .validate(UserCreateRequest::getPhone, userService::checkPhoneExits, () -> new BusinessException(BusinessCodeResponse.PHONE_AVAILABLE))
                .getData();
    }

    public UserAuthRequest validateUserAuthRequest(UserAuthRequest userAuthRequest) {
        return Validator.data(userAuthRequest)
                .validate(UserAuthRequest::getUserName, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.USER_NAME_IS_EMPTY))
                .validate(UserAuthRequest::getPassword, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.PASSWORD_IS_EMPTY))
                .validate(UserAuthRequest::getPassword, StringUtils::verifyPassword, () -> new BusinessException(BusinessCodeResponse.PASSWORD_INVALIDATE))
                .getData();
    }
}
