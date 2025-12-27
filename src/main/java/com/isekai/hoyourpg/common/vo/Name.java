// common/domain/vo/Name.java
package com.isekai.hoyourpg.common.domain.vo;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

import java.util.Objects;

public final class Name {
    private final String value;

    public Name(String value) {
        if (value == null || value.isBlank()) {
            throw new DomainException(ErrorCode.INVALID_NAME, "이름은 비어 있을 수 없습니다.");
        }
        this.value = value.trim(); //공백 제거
    }

    public String value() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name name)) return false;
        return Objects.equals(value, name.value);
    }
    @Override public int hashCode() { return Objects.hash(value); }
}
