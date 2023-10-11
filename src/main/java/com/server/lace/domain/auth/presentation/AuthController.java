package com.server.lace.domain.auth.presentation;

import com.server.lace.domain.auth.presentation.dto.request.SignInRequest;
import com.server.lace.domain.auth.presentation.dto.request.SignUpRequest;
import com.server.lace.domain.auth.presentation.dto.response.TokenResponse;
import com.server.lace.domain.auth.service.SignInService;
import com.server.lace.domain.auth.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> signIn(@RequestBody @Valid SignInRequest signInRequest) {
        TokenResponse tokenResponse = signInService.execute(signInRequest);
        return ResponseEntity.ok(tokenResponse);
    }

}
