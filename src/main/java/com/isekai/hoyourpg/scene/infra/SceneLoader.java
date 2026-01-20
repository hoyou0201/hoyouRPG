package com.isekai.hoyourpg.scene.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isekai.hoyourpg.scene.domain.*;

import java.io.InputStream;
import java.nio.file.Path;
import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;


/**
 * json으로 저장된 씬 데이터를 불러오는 객체
 * 
 */
public class SceneLoader{
    private final ObjectMapper mapper;

    public SceneLoader(ObjectMapper mapper, EffectFactory factory){
        this.mapper = mapper;
        this.factory = factory;
    }

    /**
     * InputStream을 넘기면 객체로 변환해 준다.
     */
    public Skill load(InputStream is){
        try{
            SceneSpec spec = mapper.readValue(is, SceneSpec.class);
            List<Choice> choices = spec.choiceids().stream()
                                        .map(factory::toChoice)
                                        .toList();
            
            return new Scene(
                    SceneId.of(UUID.fromString(spec.id())),
                    spec.description(),
                    choices
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load skill json", e);
        }
    }

}