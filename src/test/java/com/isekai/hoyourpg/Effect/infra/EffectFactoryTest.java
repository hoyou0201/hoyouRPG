package com.isekai.hoyourpg.Effect.infra;

import com.isekai.hoyourpg.Effect.domain.DealDamage;
import com.isekai.hoyourpg.Effect.domain.Effect;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EffectFactoryTest {

    private final EffectFactory factory = new EffectFactory();

    @Test
    @DisplayName("DealDamageSpec은 DealDamage Effect로 변환된다")
    void DealDamageSpec을_DealDamage로_변환() {
        
        DealDamageSpec spec = new DealDamageSpec(10);

        Effect effect = factory.toEffect(spec);

        assertThat(effect).isInstanceOf(DealDamage.class);

        DealDamage dmg = (DealDamage) effect;
        assertThat(dmg.amount()).isEqualTo(10);
    }

    @Test
    @DisplayName("spec이 null이면 예외")
    void null이면_변환_실패(){
        assertThatThrownBy(() -> factory.toEffect(null))
                .isInstanceOf(NullPointerException.class);

    }
}
