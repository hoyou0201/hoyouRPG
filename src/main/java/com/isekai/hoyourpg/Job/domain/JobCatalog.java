package com.isekai.hoyourpg.Job.domain;

public interface JobCatalog {
    Job findById(JobId id);
    Job findByCode(JobCode code);
}
