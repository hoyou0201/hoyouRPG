package com.isekai.hoyourpg.Skill.infra;

import com.isekai.hoyourpg.Skill.domain.*;

import java.util.Map;

public class JsonJobCatalog implements SkillCatalog{

    private final Map<SkillId, Skill> byId = new HashMap<>();

    public JsonJobCatalog(SkillLoader loader){
        ClassLoader cl = getClass().getClassLoader();

        try (InputStream indexIn = cl.getResourceAsStream("skills/index.json")) {
            SkillIndex index = mapper.readValue(indexIn, SkillIndex.class);

            for (String file : index.files()) {
                try (InputStream in = cl.getResourceAsStream("skills/" + file)) {
                    Skill skill = loader.load(in);
                    byId.put(skill.id(), skill);
                }
            }
        }
    }

    @Override
    public Skill findById(SkillId id){
        Skill skill = byId.get(id);
        if (skill == null) {
            throw new IllegalArgumentException("Unknown Skill Id: " + id);
        }
        return skill;
    }
}