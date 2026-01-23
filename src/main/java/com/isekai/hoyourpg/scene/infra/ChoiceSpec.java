package com.isekai.hoyourpg.scene.infra;

public record ChoiceSpec(
    String id,
    String description,
    String nextSceneId
) {}