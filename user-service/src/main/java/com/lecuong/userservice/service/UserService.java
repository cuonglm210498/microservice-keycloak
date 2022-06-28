package com.lecuong.userservice.service;

import com.lecuong.userservice.modal.request.user.UserAuthRequest;
import com.lecuong.userservice.modal.request.user.UserCreateRequest;
import com.lecuong.userservice.modal.request.user.UserFilterRequest;
import com.lecuong.userservice.modal.response.user.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponse auth(UserAuthRequest userAuthRequest);

    void save(UserCreateRequest userCreateRequest);

    void update(Long id, UserCreateRequest userCreateRequest);

    void delete(Long id);

    UserResponse findById(Long id);

    Page<UserResponse> getAll(Pageable pageable);

    Page<UserResponse> filter(UserFilterRequest userFilterRequest);

    boolean checkEmailExist(String email);

    boolean checkPhoneExits(String phone);

    boolean checkUserNameExist(String userName);

}
