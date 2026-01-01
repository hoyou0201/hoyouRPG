package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public class Level {
    private final int value;

    public Level(int value){
        if (value < 1) {
            throw new DomainException(ErrorCode.LEVEL_OUT_OF_RANGE, "레벨은 1 이상이어야 합니다.");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Level next() {
        return new Level(value + 1);
    }
}