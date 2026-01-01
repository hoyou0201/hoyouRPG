package com.isekai.hoyourpg.character.infra.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isekai.hoyourpg.character.domain.Job.*;
import com.isekai.hoyourpg.character.domain.Skill.SkillId;

import java.io.InputStream;
import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

public class JsonJobCatalog implements JobCatalog {

    private final Map<JobId, Job> byId = new HashMap<>();
    private final Map<JobCode, Job> byCode = new HashMap<>();

    public JsonJobCatalog(ObjectMapper mapper){
        loadAll(mapper);
    }

    private void loadAll(ObjectMapper mapper){
        //todo: json으로 index파일 만들어서 그거에 경로 다 쓰고 그걸 읽어서 쓸수 있게 바꾸기
        List<String> files = List.of(
                "jobs/unemployed.json",
                "jobs/firefighter.json",
                "jobs/warrior.json"
        );
        for(String path : files){
            Job job = loadOne(mapper, path);
            byId.put(job.id(), job);
            byCode.put(job.code(), job);
        }
    }

    private Job loadOne(ObjectMapper mapper, String path){
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if(is == null){
                throw new IllegalStateException("Job json not found: " + path);
            }

            JobJson json = mapper.readValue(is, JobJson.class);
            
            return new Job(
                    JobId.of(UUID.fromString(json.id)),
                    json.name,
                    JobCode.from(json.code),
                    JobTier.from(json.tier),
                    toJobIdSet(json.nextJobs),
                    toSkillIdSet(json.learnablePassives),
                    toSkillIdSet(json.learnableActives)
            );

        } catch (IOException e) {
            throw new IllegalStateException("Failed to load job json: " + path, e);
        }
    }

    private Set<JobId> toJobIdSet(List<String> ids){
        if(ids == null) return Set.of(); //비어있으면 빈 배열 뱉기
        return ids.stream()
                .map(UUID::fromString)
                .map(JobId::of)
                .collect(Collectors.toUnmodifiableSet());
    }

    private Set<SkillId> toSkillIdSet(List<String> ids){
        if(ids == null) return Set.of(); //비어있으면 빈 배열 뱉기
        return ids.stream()
                .map(UUID::fromString)
                .map(SkillId::of)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Job findById(JobId id) {
        Job job = byId.get(id);
        if (job == null) {
            throw new IllegalArgumentException("Unknown JobId: " + id);
        }
        return job;
    }

    @Override
    public Job findByCode(JobCode code) {
        Job job = byCode.get(code);
        if (job == null) {
            throw new IllegalArgumentException("Unknown JobCode: " + code);
        }
        return job;
    }

}

