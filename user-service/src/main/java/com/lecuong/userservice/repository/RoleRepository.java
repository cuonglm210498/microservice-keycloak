package com.lecuong.userservice.repository;

import com.lecuong.userservice.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

    List<Role> findByIdIn(List<Long> ids);
}
