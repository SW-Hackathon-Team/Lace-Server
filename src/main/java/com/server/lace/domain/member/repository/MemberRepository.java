package com.server.lace.domain.member.repository;

import com.server.lace.domain.member.entity.Member;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends CrudRepository<Member, UUID> {

    Optional<Member> findById(String id);

}