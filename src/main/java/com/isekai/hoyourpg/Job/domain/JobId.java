package com.isekai.hoyourpg.Job.domain;

import java.util.Objects;
import java.util.UUID;


/**
 * 직업을 구분해주는 vo
 * 
 * UUID를 기반으로 생성
 */
public record JobId(UUID id) {
    public JobId {
        Objects.requireNonNull(id);
    }

    public static JobId of(UUID id) {
        return new JobId(id);
    }

}
