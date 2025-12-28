package com.isekai.hoyourpg.character.domain.Job;

import com.isekai.hoyourpg.common.domain.error.ErrorCode;


/**
 * 직업티어을 구분해주는 vo(몇차 직업인지)
 * 
 */
public record JobTier(int tier) {
    public JobTier {
        if(tier < 0 || tier > 3){
            throw new DomainException(ErrorCode.INVALID_TIER, "티어는 0~3까지 가능합니다");
        }

    }

    public static JobTier from(int tier) {
        return new JobTier(tier);
    }

}
