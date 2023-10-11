package com.server.lace.domain.auth.service;

import com.server.lace.domain.auth.exception.DuplicateIdException;
import com.server.lace.domain.auth.presentation.dto.request.SignUpRequest;
import com.server.lace.domain.member.entity.Member;
import com.server.lace.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class SignUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {
        if (memberRepository.existsById(signUpRequest.getId())) {
            throw new DuplicateIdException();
        }
        Member member = Member.builder()
                .memberId(0L)
                .id(signUpRequest.getId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .name(signUpRequest.getName())
                .age(signUpRequest.getAge())
                .build();

        memberRepository.save(member);
    }

}
