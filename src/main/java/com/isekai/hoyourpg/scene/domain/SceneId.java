package com.isekai.hoyourpg.scene.domain;

import java.util.Objects;
import java.util.UUID;


/**
 * 씬을 구분해주는 vo
 * 
 * UUID를 기반으로 생성
 */
public record SceneId(UUID id) {
    public SceneId {
        Objects.requireNonNull(id);
    }

    public static SceneId of(UUID id) {
        return new SceneId(id);
    }

}
