package com.server.lace.domain.diary.entity;

import com.server.lace.domain.diary.entity.enums.Mood;
import com.server.lace.domain.member.entity.Member;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long diaryId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "mood")
    private Mood mood;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    public void update(String title, String content, String mood) {
        this.title = title;
        this.content = content;
        this.mood = Mood.toMood(mood);
    }

}