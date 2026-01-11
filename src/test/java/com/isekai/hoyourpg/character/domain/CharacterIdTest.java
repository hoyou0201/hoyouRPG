package com.isekai.hoyourpg.character.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class CharacterIdTest {

    @Test
    @DisplayName("null이면 생성에 실패한다")
    void null이면_생성_실패() {
        assertThatThrownBy(() -> CharacterId.of(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("같은 UUID면 동등하고 hashCode도 같다")
    void 같은_UUID면_동등() {
        UUID u = UUID.randomUUID();

        CharacterId a = CharacterId.of(u);
        CharacterId b = CharacterId.of(u);

        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
    }

    @Test
    @DisplayName("id는_UUID를_그대로_보관한다")
    void id는_UUID를_그대로_보관한다() {
        UUID u = UUID.randomUUID();
        assertThat(CharacterId.of(u).id()).isEqualTo(u);
    }

}
