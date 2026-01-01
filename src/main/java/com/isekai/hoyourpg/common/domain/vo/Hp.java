package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public record Hp(int value) {
    public Hp {
        if (value < 0) {
            throw new DomainException(ErrorCode.HP_NEGATIVE, "체력는 음수일 수 없습니다.");
        }
    }

    public Hp add(Hp other) {
        return new Hp(this.value + other.value);
    }

    public Hp subtract(Hp other) {
        int next = this.value - other.value;
        return new Hp(Math.max(next, 0)); //int 최소값 0
    }
}
