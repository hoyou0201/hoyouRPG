package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public record Exp(long value) {
    public Exp {
        if (value < 0) {
            throw new DomainException(ErrorCode.EXP_NEGATIVE, "경험치는 음수일 수 없습니다.");
        }
    }

    public Exp add(Exp other) {
        return new Exp(this.value + other.value);
    }

    public Exp subtract(Exp other) {
        long next = this.value - other.value;
        return new Exp(Math.max(next, 0)); //exp 최소값 0
    }
}
