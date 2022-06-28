package com.lecuong.userservice.mapper;

import com.lecuong.userservice.entity.Role;
import com.lecuong.userservice.entity.User;
import com.lecuong.userservice.modal.request.user.UserCreateRequest;
import com.lecuong.userservice.modal.response.user.UserResponse;
import com.lecuong.userservice.repository.RoleRepository;
import com.lecuong.userservice.utils.AlgorithmMd5;
import com.lecuong.userservice.utils.BeanUtils;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * author CuongLM
 */
@Data
@Component
public class UserMapper {

    private final RoleRepository roleRepository;

    public User to(UserCreateRequest userCreateRequest) {
        User user = new User();
        BeanUtils.refine(userCreateRequest, user, BeanUtils::copyNonNull);
        user.setPassword(AlgorithmMd5.getMd5(userCreateRequest.getPassword()));

        Set<Role> roles = new HashSet<>(roleRepository.findByIdIn(userCreateRequest.getIds()));
        user.setRoles(roles);

        return user;
    }

    public UserResponse to(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.refine(user, userResponse, BeanUtils::copyNonNull);
//        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
//        userResponse.setRoles(roles);
        return userResponse;
    }
}
