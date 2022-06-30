package com.lecuong.departmentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * author CuongLM
 */
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @GetMapping("/{id}")
    @RolesAllowed("user")
    public ResponseEntity<String> findById(@PathVariable long id) {
        return ResponseEntity.ok("department");
    }
}
