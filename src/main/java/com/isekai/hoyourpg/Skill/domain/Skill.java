package com.isekai.hoyourpg.Skill.domain;

import java.util.List;

import com.isekai.hoyourpg.Effect.domain.Effect;

public record Skill(
    SkillId id,
    String name,
    SkillCode code,
    List<Effect> effects) {
}