package com.isekai.hoyourpg.common.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

class MpTest {

    @Test
    @DisplayName("음수면 생성에 실패한다")
    void 음수면_생성_실패() {
        assertThatThrownBy(() -> new Mp(-1))
                .isInstanceOf(DomainException.class);
    }

    @Test
    @DisplayName("마나을 더할수 있다")
    void 마나을_더할수_있다(){
        Mp mp = new Mp(100).add(new Mp(50));
        assertThat(mp.value()).isEqualTo(150);
    }

    @Test
    @DisplayName("마나는 0아래로 내려가지 않는다")
    void 마나는_0아래로_내려가지_않는다(){
        Mp mp = new Mp(50).subtract(new Mp(100));
        assertThat(mp.value()).isZero();
    }

}
