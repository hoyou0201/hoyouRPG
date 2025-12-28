package com.isekai.hoyourpg.character.domain.Job;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class JobIdTest {

    @Test
    @DisplayName("null이면 생성에 실패한다")
    void null이면_생성_실패() {
        assertThatThrownBy(() -> JobId.of(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("같은 UUID면 동등하고 hashCode도 같다")
    void 같은_UUID면_동등() {
        UUID u = UUID.randomUUID();

        JobId a = JobId.of(u);
        JobId b = JobId.of(u);

        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
    }

    @Test
    @DisplayName("toString은 UUID 문자열을 그대로 반환한다")
    void toString은_UUID문자열() {
        UUID u = UUID.randomUUID();

        assertThat(JobId.of(u).toString()).isEqualTo(u.toString());
    }
}
