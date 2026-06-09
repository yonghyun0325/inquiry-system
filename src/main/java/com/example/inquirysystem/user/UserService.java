package com.example.inquirysystem.user;

import com.example.inquirysystem.common.ApiResponse;
import com.example.inquirysystem.security.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider,
            RefreshTokenRepository refreshTokenRepository
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public ApiResponse<UserResponse> signup(
            UserSignupRequest request
    ) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
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

    @Transactional
    public ApiResponse<LoginResponse> login(
            UserLoginRequest request
    ) {

        User user = userRepository.findByEmail(
                        request.getEmail()
                )
                .orElseThrow(() ->
                        new RuntimeException("존재하지 않는 이메일입니다.")
                );

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException(
                    "비밀번호가 일치하지 않습니다."
            );
        }

        String accessToken =
                jwtProvider.createToken(
                        user.getEmail(),
                        user.getRole()
                );

        String refreshToken =
                jwtProvider.createRefreshToken(
                        user.getEmail()
                );

        refreshTokenRepository.deleteByUserId(
                user.getId()
        );

        RefreshToken refreshTokenEntity =
                new RefreshToken();

        refreshTokenEntity.setUserId(
                user.getId()
        );

        refreshTokenEntity.setToken(
                refreshToken
        );

        refreshTokenEntity.setExpiredAt(
                LocalDateTime.now().plusDays(14)
        );

        refreshTokenRepository.save(
                refreshTokenEntity
        );

        return new ApiResponse<>(
                true,
                "로그인 성공",
                new LoginResponse(
                        accessToken,
                        refreshToken
                )
        );
    }

    public ApiResponse<UserMeResponse> getMyInfo(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("사용자를 찾을 수 없습니다.")
                );

        return new ApiResponse<>(
                true,
                "내 정보 조회 성공",
                new UserMeResponse(user)
        );
    }

    // 관리자 회원 목록 조회
    public ApiResponse<List<AdminUserResponse>> getAllUsersForAdmin() {

        List<AdminUserResponse> users = userRepository.findAll()
                .stream()
                .map(AdminUserResponse::new)
                .toList();

        return new ApiResponse<>(
                true,
                "회원 목록 조회 성공",
                users
        );
    }

    // 사용자 권한 변경
    public ApiResponse<String> updateUserRole(
            Long userId,
            RoleUpdateRequest request
    ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("사용자를 찾을 수 없습니다.")
                );

        user.setRole(request.getRole());

        userRepository.save(user);

        return new ApiResponse<>(
                true,
                "권한 변경 성공",
                user.getRole()
        );
    }

    // 사용자 상태 변경
    public ApiResponse<String> updateUserStatus(
            Long userId,
            StatusUpdateRequest request
    ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("사용자를 찾을 수 없습니다.")
                );

        user.setStatus(request.getStatus());

        userRepository.save(user);

        return new ApiResponse<>(
                true,
                "상태 변경 성공",
                user.getStatus()
        );
    }

    public ApiResponse<TokenRefreshResponse> refreshToken(
            RefreshTokenRequest request
    ) {

        RefreshToken refreshToken = refreshTokenRepository
                .findByToken(request.getRefreshToken())
                .orElseThrow(() ->
                        new RuntimeException("유효하지 않은 Refresh Token입니다.")
                );

        User user = userRepository.findById(
                        refreshToken.getUserId()
                )
                .orElseThrow(() ->
                        new RuntimeException("사용자를 찾을 수 없습니다.")
                );

        String newAccessToken =
                jwtProvider.createToken(
                        user.getEmail(),
                        user.getRole()
                );

        return new ApiResponse<>(
                true,
                "Access Token 재발급 성공",
                new TokenRefreshResponse(
                        newAccessToken
                )
        );
    }

    public ApiResponse<String> logout(
            LogoutRequest request
    ) {

        RefreshToken refreshToken = refreshTokenRepository
                .findByToken(
                        request.getRefreshToken()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Refresh Token이 존재하지 않습니다."
                        )
                );

        refreshTokenRepository.delete(
                refreshToken
        );

        return new ApiResponse<>(
                true,
                "로그아웃 성공",
                null
        );
    }
}