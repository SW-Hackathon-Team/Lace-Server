package com.server.lace.domain.diary.service;

import com.server.lace.domain.diary.entity.Diary;
import com.server.lace.domain.diary.exception.DiaryNotFoundException;
import com.server.lace.domain.diary.repository.DiaryRepository;
import com.server.lace.domain.member.entity.Member;
import com.server.lace.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteDiaryService {

    private final DiaryRepository diaryRepository;
    private final MemberUtil memberUtil;

    @Transactional
    public void execute(Long diaryId) {
        Member member = memberUtil.currentMember();
        if (!diaryRepository.existsByMemberAndDiaryId(member, diaryId)) {
            throw new DiaryNotFoundException();
        }
        diaryRepository.deleteByDiaryId(diaryId);
    }

}
