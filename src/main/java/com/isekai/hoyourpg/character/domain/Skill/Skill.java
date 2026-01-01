package com.isekai.hoyourpg.character.domain.Skill;

import java.util.Set;

import com.isekai.hoyourpg.character.domain.Effect.Effect;

public record Skill(
    SkillId id,
    String name,
    SkillCode code,
    Set<Effect> effects) {
}