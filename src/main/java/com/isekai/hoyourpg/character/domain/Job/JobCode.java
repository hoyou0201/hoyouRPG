package com.isekai.hoyourpg.character.domain.Job;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public record JobCode(String code) {
    public JobCode{
        if (code == null || code.isBlank()) {
            throw new DomainException(ErrorCode.INVALID_CODE, "코드는 비어 있을 수 없습니다.");
        }
        this.code = code.trim(); //공백 제거
    }

    public static JobCode from(String code) {
        return new JobCode(code);
    }
}