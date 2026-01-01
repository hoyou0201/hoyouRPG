package com.isekai.hoyourpg.common.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

class LevelTest {

    @Test
    @DisplayName("레벨은 1이상이다")
    void 레벨은_1이상() {
        assertThatThrownBy(() -> new Level(0))
                .isInstanceOf(DomainException.class);
    }

    @Test
    @DisplayName("다음레벨은 1커진다")
    void 다음레벨은_1커진다(){
        Level level = new Level(5).next();
        assertThat(level.value()).isEqualTo(6);
    }


}
