package com.isekai.hoyourpg.Job.infra;

import java.util.List;

public class JobJson {
    public String id;
    public String code;
    public String name;
    public int tier;
    public List<String> nextJobs;
    public List<String> learnablePassives;
    public List<String> learnableActives;
}
