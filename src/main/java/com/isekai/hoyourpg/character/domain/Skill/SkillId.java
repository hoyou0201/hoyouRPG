package com.isekai.hoyourpg.character.domain.Skill;

import java.util.Objects;
import java.util.UUID;


public record SkillId(UUID id) {
    public SkillId {
        Object.requireNonNull(id);
    }

    public static SkillId of(UUID id) {
        return new SkillId(id);
    }

}
