package com.isekai.hoyourpg.Effect.infra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;

class EffectSpecTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("type이 dealDamage이면 DealDamageSpec으로 역직렬화된다")
    void DealDamageSpec으로_역직렬화() throws Exception {
        String json = """
        {
            "type": "dealDamage",
            "amount": 10
        }
        """;

        EffectSpec spec = mapper.readValue(json, EffectSpec.class);

        assertThat(spec).isInstanceOf(DealDamageSpec.class);

        DealDamageSpec damageSpec = (DealDamageSpec) spec;
        assertThat(damageSpec.amount()).isEqualTo(10);
    }

    @Test
    @DisplayName("알 수 없는 type이면 역직렬화에 실패한다")
    void unknown_type_should_fail() {
        String json = """
        {
            "type": "ghghghg",
            "amount": 10
        }
        """;

        assertThatThrownBy(() ->
            mapper.readValue(json, EffectSpec.class)
        ).isInstanceOf(InvalidTypeIdException.class);
    }
    
}