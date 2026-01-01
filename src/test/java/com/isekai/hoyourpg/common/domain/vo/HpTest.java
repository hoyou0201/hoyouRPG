package com.isekai.hoyourpg.common.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

class HpTest {

    @Test
    @DisplayName("음수면 생성에 실패한다")
    void 음수면_생성_실패() {
        assertThatThrownBy(() -> new Hp(-1))
                .isInstanceOf(DomainException.class);
    }

    @Test
    @DisplayName("체력을 더할수 있다")
    void 체력을_더할수_있다(){
        Hp hp = new Hp(100).add(new Hp(50));
        assertThat(hp.value()).isEqualTo(150);
    }

    @Test
    @DisplayName("체력은 0아래로 내려가지 않는다")
    void 체력은_0아래로_내려가지_않는다(){
        Hp hp = new Hp(50).subtract(new Hp(100));
        assertThat(hp.value()).isZero();
    }

}
