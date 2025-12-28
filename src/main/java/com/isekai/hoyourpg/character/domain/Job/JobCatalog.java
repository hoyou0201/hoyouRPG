package com.isekai.hoyourpg.character.domain.job;

public interface JobCatalog {
    Job findById(JobId id);
    Job findByCode(JobCode code);
}
