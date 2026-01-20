package com.isekai.hoyourpg.scene.domain;

import java.util.Objects;
import java.util.UUID;


/**
 * 선택지을 구분해주는 vo
 * 
 * UUID를 기반으로 생성
 */
public record ChoiceId(UUID id) {
    public ChoiceId {
        Objects.requireNonNull(id);
    }

    public static ChoiceId of(UUID id) {
        return new ChoiceId(id);
    }

}
