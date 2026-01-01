package com.isekai.hoyourpg.battle.domain;

import com.isekai.hoyourpg.character.domain.Character;

public final class BattleContext {

    private final Character attacker;
    private final Character target;

    public BattleContext(Character attacker, Character target) {
        this.attacker = attacker;
        this.target = target;
    }

    public Character attacker() {
        return attacker;
    }

    public Character target() {
        return target;
    }
}
