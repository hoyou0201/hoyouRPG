package com.isekai.hoyourpg.scene.domain;

import java.util.Objects;
import java.util.UUID;


public record Choice(
    String description,
    ChoiceId id,
    SceneId nextSceneId,
    //reward 추가 필요
) {
    

}
