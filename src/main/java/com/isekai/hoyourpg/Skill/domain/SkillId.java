package com.isekai.hoyourpg.Skill.domain;

import java.util.Objects;
import java.util.UUID;


public record SkillId(UUID id) {
    public SkillId {
        Objects.requireNonNull(id);
    }

    public static SkillId of(UUID id) {
        return new SkillId(id);
    }

}
