package com.server.lace.domain.diary.repository;

import com.server.lace.domain.diary.entity.Diary;
import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository<Diary, Long> {

}
