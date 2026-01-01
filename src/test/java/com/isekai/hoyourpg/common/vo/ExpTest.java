package com.isekai.hoyourpg.common.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

class ExpTest {

    @Test
    @DisplayName("음수면 생성에 실패한다")
    void 음수면_생성_실패() {
        assertThatThrownBy(() -> new Exp(-1))
                .isInstanceOf(DomainException.class);
    }

    @Test
    @DisplayName("경험치를 더할수 있다")
    void 경험치를_더할수_있다(){
        Exp exp = new Exp(100).add(new Exp(50));
        assertThat(exp.value()).isEqualTo(150);
    }

    @Test
    @DisplayName("경험치는 0아래로 내려가지 않는다")
    void 경험치는_0아래로_내려가지_않는다(){
        Exp exp = new Exp(50).subtract(new Exp(100));
        assertThat(exp.value()).isZero();
    }

}
