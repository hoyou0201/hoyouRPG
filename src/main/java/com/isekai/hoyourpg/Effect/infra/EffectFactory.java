package com.isekai.hoyourpg.Effect.infra;

import com.isekai.hoyourpg.Effect.domain.Effect;

public class EffectFactory{
    
    public Effect toEffect(EffectSpec spec){
        return switch(spec){
            case DealDamegeSpec s -> 
                new DealDamege(s.amount());
        };
    }


}
