package com.example.inquirysystem.user;

import com.example.inquirysystem.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<UserResponse> signup(
            @Valid @RequestBody UserSignupRequest request
    ) {
        return userService.signup(request);
    }

    @PostMapping("/login")
    public ApiResponse<UserResponse> login(
            @Valid @RequestBody UserLoginRequest request
    ) {
        return userService.login(request);
    }
}