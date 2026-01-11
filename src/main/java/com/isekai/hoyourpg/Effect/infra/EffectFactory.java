package com.isekai.hoyourpg.Effect.infra;

import com.isekai.hoyourpg.Effect.domain.*;

public class EffectFactory{
    
    public Effect toEffect(EffectSpec spec){
        Objects.requireNonNull(spec, "spec");
        return switch(spec){
            case DealDamageSpec s -> 
                new DealDamage(s.amount());
        };
    }


}
