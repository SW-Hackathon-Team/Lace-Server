package com.server.lace.domain.auth.presentation;

import com.server.lace.domain.auth.presentation.dto.request.SignUpRequest;
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
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignUpService signUpService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
