package com.server.lace.domain.diary.service;

import com.server.lace.domain.diary.entity.Diary;
import com.server.lace.domain.diary.entity.enums.Mood;
import com.server.lace.domain.diary.exception.MoodNotFoundException;
import com.server.lace.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.server.lace.domain.diary.repository.DiaryRepository;
import com.server.lace.domain.member.entity.Member;
import com.server.lace.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateDiaryService {

    private final DiaryRepository diaryRepository;
    private final MemberUtil memberUtil;

    @Transactional
    public void execute(CreateDiaryRequest createDiaryRequest) {
        Member member = memberUtil.currentMember();
        Mood mood = Mood.toMood(createDiaryRequest.getMood());
        if (mood == null) {
            throw new MoodNotFoundException();
        }
        Diary diary = Diary.builder()
                .diaryId(0L)
                .title(createDiaryRequest.getTitle())
                .content(createDiaryRequest.getContent())
                .mood(mood)
                .member(member)
                .createdAt(LocalDateTime.now())
                .build();
        diaryRepository.save(diary);
    }

}
