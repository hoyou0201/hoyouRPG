package com.isekai.hoyourpg.Skill.domain;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

public record SkillCode(String code) {
    public SkillCode{
        if (code == null || code.isBlank()) {
            throw new DomainException(ErrorCode.INVALID_CODE, "코드는 비어 있을 수 없습니다.");
        }
        code = code.trim(); //공백 제거
    }

    public static SkillCode from(String code) {
        return new SkillCode(code);
    }
}