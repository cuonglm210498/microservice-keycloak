package com.lecuong.userservice.controller.user;

import com.lecuong.userservice.controller.BaseController;
import com.lecuong.userservice.modal.AccountInfo;
import com.lecuong.userservice.modal.BaseResponse;
import com.lecuong.userservice.modal.request.user.UserCreateRequest;
import com.lecuong.userservice.modal.request.user.UserFilterRequest;
import com.lecuong.userservice.modal.response.user.UserResponse;
import com.lecuong.userservice.service.UserService;
import com.lecuong.userservice.validate.UserValidator;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * author CuongLM
 */
@Data
@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController {

    private final AccountInfo accountInfo;
    private final UserValidator userValidator;
    private final UserService userService;

    @PostMapping
    @RolesAllowed({"admin", "user"})
    public ResponseEntity<BaseResponse<Void>> create(@RequestBody UserCreateRequest userCreateRequest) {

        userValidator.validateUserCreateRequest(userCreateRequest);
        userService.save(userCreateRequest);
        return ResponseEntity.ok(BaseResponse.ofSuccess(null));
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({"admin", "user"})
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable Long id) {
        userService.delete(id);
        return success(null);
    }

    @PutMapping("/{id}")
    @RolesAllowed({"admin", "user"})
    public ResponseEntity<BaseResponse<Void>> update(@PathVariable Long id,
                                                     @RequestBody UserCreateRequest userCreateRequest) {
        userValidator.validateUserCreateRequest(userCreateRequest);
        userService.update(id, userCreateRequest);
        return success(null);
    }

    @GetMapping("/{id}")
    @RolesAllowed({"user"})
    public ResponseEntity<BaseResponse<UserResponse>> findById(@PathVariable Long id) {
        UserResponse userResponse = userService.findById(id);
        return success(userResponse);
    }

    @GetMapping
    @RolesAllowed({"admin", "user"})
    public ResponseEntity<BaseResponse<Page<UserResponse>>> getAll(@RequestParam int pageIndex,
                                                                   @RequestParam int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
        Page<UserResponse> userResponses = userService.getAll(pageRequest);
        return success(userResponses);
    }

    @GetMapping("/filter")
    @RolesAllowed({"admin", "user"})
    public ResponseEntity<BaseResponse<Page<UserResponse>>> filter(@ModelAttribute UserFilterRequest userFilterRequest) {
        Page<UserResponse> userResponses = userService.filter(userFilterRequest);
        return success(userResponses);
    }
}
