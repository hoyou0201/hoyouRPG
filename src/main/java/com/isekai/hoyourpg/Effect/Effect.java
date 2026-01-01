package com.isekai.hoyourpg.character.domain.Effect;

import com.isekai.hoyourpg.battle.domain.BattleContext;

public interface Effect {
    void apply(BattleContext ctx);
}