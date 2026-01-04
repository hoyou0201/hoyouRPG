package com.isekai.hoyourpg.Skill.infra;

import com.isekai.hoyourpg.Effect.infra.EffectSpec;

import java.util.List;

public record SkillSpec(
    String id,
    String name,
    String code,
    List<EffectSpec> effectspecs
) {}