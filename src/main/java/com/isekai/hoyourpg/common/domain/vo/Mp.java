package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public record Mp(int value) {

    public Mp {
        if (value < 0) {
            throw new DomainException(ErrorCode.MP_NEGATIVE, "체력는 음수일 수 없습니다.");
        }
    }

    public Mp add(Mp other) {
        return new Mp(this.value + other.value);
    }

    public Mp subtract(Mp other) {
        int next = this.value - other.value;
        return new Mp(Math.max(next, 0)); //int 최소값 0
    }
}
