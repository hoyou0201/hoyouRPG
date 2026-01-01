package com.isekai.hoyourpg.character.domain.Job;

public interface JobCatalog {
    Job findById(JobId id);
    Job findByCode(JobCode code);
}
