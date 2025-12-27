package com.isekai.hoyourpg.character.domain.job;

import java.util.Objects;
import java.util.UUID;

public final class JobId {
    private final UUID value;

    private JobId(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public static JobId newId() {
        return new JobId(UUID.randomUUID());
    }

    public static JobId of(UUID value) {
        return new JobId(value);
    }

    public UUID value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobId that)) return false;
        return Objects.equals(value, that.value);
    }
    
    @Override public int hashCode() { return Objects.hash(value); }
}
