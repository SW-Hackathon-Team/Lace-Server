package com.server.lace.domain.auth.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.util.concurrent.TimeUnit;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@RedisHash(value = "refreshToken__lace")
public class RefreshToken {

    @Id
    private String id;

    private String refreshToken;

    @TimeToLive(unit = TimeUnit.SECONDS)
    private long expiredAt;

}
