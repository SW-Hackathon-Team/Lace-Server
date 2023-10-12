package com.server.lace.domain.diary.service;

import com.server.lace.domain.diary.entity.Diary;
import com.server.lace.domain.diary.exception.DiaryNotFoundException;
import com.server.lace.domain.diary.presentation.dto.request.UpdateDiaryRequest;
import com.server.lace.domain.diary.repository.DiaryRepository;
import com.server.lace.domain.member.entity.Member;
import com.server.lace.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateDiaryService {

    private final DiaryRepository diaryRepository;
    private final MemberUtil memberUtil;

    @Transactional
    public void execute(UpdateDiaryRequest updateDiaryRequest) {
        Member member = memberUtil.currentMember();
        Diary diary = diaryRepository.findByMember(member)
                .orElseThrow(()->new DiaryNotFoundException());

        diary.update(updateDiaryRequest.getTitle(), updateDiaryRequest.getContent(), updateDiaryRequest.getMood());
        diaryRepository.save(diary);
    }

}
