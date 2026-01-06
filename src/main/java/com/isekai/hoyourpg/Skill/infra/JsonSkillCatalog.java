package com.isekai.hoyourpg.Skill.infra;

import com.isekai.hoyourpg.Skill.domain.*;

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSkillCatalog implements SkillCatalog{

    private final Map<SkillId, Skill> byId = new HashMap<>();

    public JsonSkillCatalog(SkillLoader loader, ObjectMapper mapper){
        ClassLoader cl = getClass().getClassLoader();

        try (InputStream indexIn = cl.getResourceAsStream("skills/index.json")) {
            SkillIndex index = mapper.readValue(indexIn, SkillIndex.class);
            if (indexIn == null) {
                throw new IllegalStateException("Skill index json not found: skills/index.json");
            }
            for (String file : index.files()) {
                try (InputStream in = cl.getResourceAsStream("skills/" + file)) {
                    if(in == null){
                        throw new IllegalStateException("Skill json not found: " + file);
                    }
                    Skill skill = loader.load(in);
                    byId.put(skill.id(), skill);
                }
                catch (IOException e) {
                    throw new IllegalStateException("Failed to load skill json: " + file, e);
                }

            }
        }
        catch (IOException e) {
            throw new IllegalStateException("Failed to load skill index json: ", e);
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