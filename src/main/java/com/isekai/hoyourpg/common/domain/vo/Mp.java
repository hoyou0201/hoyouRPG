package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public final class Mp {
    private final int value;

    public Mp(int value) {
        if (value < 0) {
            throw new DomainException(ErrorCode.MP_NEGATIVE, "체력는 음수일 수 없습니다.");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Mp add(Mp other) {
        return new Mp(this.value + other.value);
    }

    public Mp subtract(int amount) {
        int next = this.value - amount;
        return new Mp(Math.max(next, 0)); //int 최소값 0
    }
}
