package com.isekai.hoyourpg.scene.domain;

import java.util.Objects;
import java.util.UUID;


public record Choice(
    ChoiceId id,
    String description,
    SceneId nextSceneId,
    //reward 추가 필요
) {
    

}
