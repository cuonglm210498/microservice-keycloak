package com.lecuong.userservice.repository.specification;

import com.lecuong.userservice.entity.User;
import com.lecuong.userservice.modal.request.user.UserFilterRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> filter(UserFilterRequest userFilterRequest) {
        return Specification.where(withUserName(userFilterRequest.getUserName()))
                .and(withAddress(userFilterRequest.getAddress()))
                .and(withEmail(userFilterRequest.getEmail()))
                .and(withCreatedBy(userFilterRequest.getCreatedBy()))
                .and(withStatus(userFilterRequest.getStatus()))
                .or(withUserNameLike(userFilterRequest.getUserName()));
    }

    public static Specification<User> withUserName(String userName) {
        if (StringUtils.isBlank(userName))
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userName"), userName);
    }

    public static Specification<User> withAddress(String address) {
        if (StringUtils.isBlank(address))
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("address"), address);
    }

    public static Specification<User> withEmail(String email) {
        if (StringUtils.isBlank(email))
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<User> withUserNameLike(String userName) {
        if (StringUtils.isBlank(userName))
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("userName"), "%" + userName + "%");
    }

    private static Specification<User> withCreatedBy(String createdBy) {
        if (StringUtils.isEmpty(createdBy)) return null;

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("createdBy"), createdBy);
    }

    private static Specification<User> withStatus(Boolean status) {
        if (status == null) return null;

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }
}
