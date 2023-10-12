package com.server.lace.domain.diary.repository;

import com.server.lace.domain.diary.entity.Diary;
import com.server.lace.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findByMemberAndDiaryId(Member member, Long diaryId);
    void deleteByDiaryId(Long diaryId);
    boolean existsByMemberAndDiaryId(Member member, Long diaryId);
}
