package com.isekai.hoyourpg.Skill.domain;

import java.util.Set;

import com.isekai.hoyourpg.Effect.domain.Effect;

public record Skill(
    SkillId id,
    String name,
    SkillCode code,
    Set<Effect> effects) {
}