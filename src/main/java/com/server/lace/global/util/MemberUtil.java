package com.server.lace.global.util;

import com.server.lace.domain.member.entity.Member;
import com.server.lace.domain.member.exception.MemberNotFoundException;
import com.server.lace.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberUtil {

    private final MemberRepository memberRepository;

    public Member currentMember() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberRepository.findByLoginId(id)
                .orElseThrow(() -> new MemberNotFoundException());
    }

}