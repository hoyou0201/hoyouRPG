package com.isekai.hoyourpg.character.domain;

import java.util.Objects;
import java.util.UUID;


public record CharacterId(UUID id) {
    public CharacterId {
        Objects.requireNonNull(id);
    }

    public static CharacterId of(UUID id) {
        return new CharacterId(id);
    }

}
