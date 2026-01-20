package com.isekai.hoyourpg.scene.domain;

import java.util.Objects;
import java.util.Set;

public record Scene(
    SceneId id,
    String description;
    Set<ChoiceId> choiceIds;
) {

}
