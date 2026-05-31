package com.example.inquirysystem.user;

import com.example.inquirysystem.common.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse<UserResponse> signup(
            UserSignupRequest request
    ) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setPhone(request.getPhone());

        user.setRole("ROLE_USER");
        user.setStatus("ACTIVE");

        User savedUser = userRepository.save(user);

        return new ApiResponse<>(
                true,
                "회원가입 성공",
                new UserResponse(savedUser)
        );
    }

    public ApiResponse<UserResponse> login(
            UserLoginRequest request
    ) {

        User user = userRepository.findByEmail(
                        request.getEmail()
                )
                .orElseThrow(() ->
                        new RuntimeException("존재하지 않는 이메일입니다.")
                );

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return new ApiResponse<>(
                true,
                "로그인 성공",
                new UserResponse(user)
        );
    }
}