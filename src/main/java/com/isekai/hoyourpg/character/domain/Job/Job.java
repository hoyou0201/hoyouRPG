package character.domain.job;

import java.util.Set;

public class Job {
    private final JobId id;
    private final String name;
    private final JobTier tier;

    private final Set<JobId> nextJobs;

    private final Set<SkillId> learnablePassives;
    private final Set<SkillId> learnableActives;

    public Job(JobId id,
               String name,
               JobTier tier,
               Set<JobId> nextJobs,
               Set<SkillId> learnablePassives,
               Set<SkillId> learnableActives) {
        this.id = id;
        this.name = name;
        this.tier = tier;
        this.nextJobs = Set.copyOf(nextJobs);
        this.learnablePassives = Set.copyOf(learnablePassives);
        this.learnableActives = Set.copyOf(learnableActives);
    }

    public JobId id() { return id; }
    public String name() { return name; }
    public JobTier tier() { return tier; }

    public Set<JobId> nextJobsSet() { return nextJobs; }
    public Set<JobId> learnablePassivesSet() { return learnablePassives; }
    public Set<JobId> learnableActivesSet() { return learnableActives; }
}
