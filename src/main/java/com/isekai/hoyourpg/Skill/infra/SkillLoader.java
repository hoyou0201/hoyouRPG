package com.isekai.hoyourpg.Skill.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isekai.hoyourpg.Skill.domain.*;
import com.isekai.hoyourpg.Effect.domain.Effect;
import com.isekai.hoyourpg.Effect.infra.EffectFactory;
import com.isekai.hoyourpg.Effect.infra.EffectSpec;

import java.io.InputStream;
import java.nio.file.Path;
import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

public class SkillLoader{
    private final ObjectMapper mapper;
    private final EffectFactory factory;

    public SkillLoader(ObjectMapper mapper, EffectFactory factory){
        this.mapper = mapper;
        this.factory = factory;
    }

    public Skill load(String path){
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if(is == null){
                throw new IllegalStateException("Skill json not found: " + path);
            }

            SkillSpec spec = mapper.readValue(is, SkillSpec.class);

            List<Effect> effects = spec.effectspecs.stream()
                                    .map(factory::toEffect)
                                    .toList();
            
            
            return new Skill(
                    SkillId.of(UUID.fromString(spec.id)),
                    spec.name,
                    SkillCode.from(spec.code),
                    effects
            );

        } catch (IOException e) {
            throw new IllegalStateException("Failed to load skill json: " + path, e);
        }

    }

    public Set<Effect> to
}