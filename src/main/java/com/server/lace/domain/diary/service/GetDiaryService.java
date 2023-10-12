package com.server.lace.domain.diary.service;

import com.server.lace.domain.diary.entity.Diary;
import com.server.lace.domain.diary.exception.DiaryNotFoundException;
import com.server.lace.domain.diary.presentation.dto.response.DiaryResponse;
import com.server.lace.domain.diary.repository.DiaryRepository;
import com.server.lace.domain.member.entity.Member;
import com.server.lace.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetDiaryService {

    private final DiaryRepository diaryRepository;
    private final MemberUtil memberUtil;

    @Transactional(readOnly = true)
    public DiaryResponse execute() {
        Member member = memberUtil.currentMember();
        Diary diary = diaryRepository.findByMember(member)
                .orElseThrow(DiaryNotFoundException::new);

        return DiaryResponse.builder()
                .title(diary.getTitle())
                .content(diary.getContent())
                .mood(diary.getMood().toString())
                .createdAt(diary.getCreatedAt())
                .build();
    }

}