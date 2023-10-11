package com.server.lace.domain.auth.service;

import com.server.lace.domain.auth.entity.RefreshToken;
import com.server.lace.domain.auth.exception.MisMatchPasswordException;
import com.server.lace.domain.auth.presentation.dto.request.SignInRequest;
import com.server.lace.domain.auth.presentation.dto.response.TokenResponse;
import com.server.lace.domain.auth.repository.RefreshTokenRepository;
import com.server.lace.domain.member.entity.Member;
import com.server.lace.domain.member.exception.MemberNotFoundException;
import com.server.lace.domain.member.repository.MemberRepository;
import com.server.lace.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.Token;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class SignInService {

    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public TokenResponse execute(SignInRequest signInRequest) {
        Member member = memberRepository.findByLoginId(signInRequest.getLoginId())
                .orElseThrow(()->new MemberNotFoundException());

        if (!passwordEncoder.matches(signInRequest.getPassword(), member.getPassword())) {
            throw new MisMatchPasswordException();
        }

        String accessToken = tokenProvider.generatedAccessToken(signInRequest.getLoginId());
        String refreshToken = tokenProvider.generatedRefreshToken(signInRequest.getLoginId());
        RefreshToken entityRedis = new RefreshToken(signInRequest.getLoginId(), refreshToken, tokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());

        refreshTokenRepository.save(entityRedis);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiredAt(tokenProvider.getExpiredAtAccessToken().toLocalDateTime())
                .refreshTokenExpiredAt(tokenProvider.getExpiredAtRefreshToken().toLocalDateTime())
                .build();
    }
}
