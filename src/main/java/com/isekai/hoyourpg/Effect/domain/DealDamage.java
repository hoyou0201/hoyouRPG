package com.isekai.hoyourpg.Effect.domain;

import com.isekai.hoyourpg.battle.domain.BattleContext;

public class DealDamage implements Effect{
    private int amount;

    public DealDamage(int amount){
        this.amount = amount;
    }

    @Override
    public void apply(BattleContext ctx){

    }

    public int amount(){
        return amount;
    }
    
}