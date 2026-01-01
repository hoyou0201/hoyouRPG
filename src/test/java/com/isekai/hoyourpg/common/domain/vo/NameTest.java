package com.isekai.hoyourpg.common.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.isekai.hoyourpg.common.domain.error.DomainException;
import com.isekai.hoyourpg.common.domain.error.ErrorCode;

class NameTest {

    @Test
    @DisplayName("빈이름은 생성 실패한다")
    void 빈이름이면_생성_실패() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(DomainException.class);
    }

    @Test
    @DisplayName("null은 생성 실패한다")
    void null이면_생성_실패() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(DomainException.class);
    }

    @Test
    @DisplayName("띄어쓰기만 있어도 생성 실패한다")
    void 띄어쓰기이면_생성_실패() {
        assertThatThrownBy(() -> new Name("  "))
                .isInstanceOf(DomainException.class);
    }

    @Test
    @DisplayName("공백은 제거된다")
    void 공백은_제거(){
        Name Name = new Name("   이름");
        assertThat(Name.value()).isEqualTo("이름");
    }


}
