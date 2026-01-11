package com.isekai.hoyourpg.Effect.infra;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @Type(value = DealDamageSpec.class, name = "dealDamage")
})
public sealed interface EffectSpec permits DealDamageSpec{}