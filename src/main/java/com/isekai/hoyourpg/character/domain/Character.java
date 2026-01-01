// character/domain/Character.java
package com.isekai.hoyourpg.character.domain;

import com.isekai.hoyourpg.common.domain.vo.Exp;
import com.isekai.hoyourpg.common.domain.vo.Level;
import com.isekai.hoyourpg.common.domain.vo.Name;
import com.isekai.hoyourpg.Job.domain.JobId;

import java.util.Objects;

public class Character {
    private Name name;
    private Level level;
    private Exp exp;
    private JobId jobId;
    private CharacterId id;

    public Character(CharacterId id, Name name, JobId jobId) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.level = new Level(1);
        this.exp = new Exp(0);
        this.jobId = jobId;
    }

    
    public Name name() { return name; }
    public Level level() { return level; }
    public Exp exp() { return exp; }
    
}
