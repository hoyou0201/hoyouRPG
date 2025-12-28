package com.isekai.hoyourpg.character.domain.job;

import java.util.Objects;
import java.util.Set;

public record Job(
    JobId id,
    String name,
    JobCode code,
    JobTier tier,
    Set<JobId> nextJobs,
    Set<SkillId> learnablePassives,
    Set<SkillId> learnableActives
) {

    public Job {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(tier, "tier must not be null");

        nextJobs = Set.copyOf(nextJobs);
        learnablePassives = Set.copyOf(learnablePassives);
        learnableActives = Set.copyOf(learnableActives);
    }

    public boolean canPromoteTo(JobId targetJobId) {
        return nextJobs.contains(targetJobId);
    }

    public boolean canLearnPassive(SkillId skillId) {
        return learnablePassives.contains(skillId);
    }

    public boolean canLearnActive(SkillId skillId) {
        return learnableActives.contains(skillId);
    }
}
