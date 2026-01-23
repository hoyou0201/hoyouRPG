package com.isekai.hoyourpg.scene.infra;

import java.util.List;

public record SceneSpec(
    String id,
    String description,
    List<ChoiceSpec> choices
) {}