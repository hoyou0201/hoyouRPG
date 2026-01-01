package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public record Level(int value) {

    public Level(int value){
        if (value < 1) {
            throw new DomainException(ErrorCode.LEVEL_OUT_OF_RANGE, "레벨은 1 이상이어야 합니다.");
        }
    }

    public Level next() {
        return new Level(value + 1);
    }
}