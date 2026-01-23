package com.isekai.hoyourpg.scene.infra;

import com.isekai.hoyourpg.scene.domain.*;
import java.util.Objects;
import java.util.UUID;

/**
 * Choice 를 만들어주는 객체
 * 
 */
public class ChoiceFactory{
    /**
     * ChoiceSpec을 Choice로 변환
     */
    public Choice toChoice(ChoiceSpec spec){
        Objects.requireNonNull(spec, "spec");
        return new Choice(ChoiceId.of(UUID.fromString(spec.id())),
                        spec.description(),
                        SceneId.of(UUID.fromString(spec.nextSceneId())));
    }

}