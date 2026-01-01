// common/domain/vo/Name.java
package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

import java.util.Objects;

public record Name(String value) {
    public Name{
        if (value == null || value.isBlank()) {
            throw new DomainException(ErrorCode.INVALID_NAME, "이름은 비어 있을 수 없습니다.");
        }
        value = value.trim(); //공백 제거
    }
}
