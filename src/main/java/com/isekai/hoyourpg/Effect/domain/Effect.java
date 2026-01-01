package com.isekai.hoyourpg.Effect.domain;

import com.isekai.hoyourpg.battle.domain.BattleContext;

public interface Effect {
    void apply(BattleContext ctx);
}