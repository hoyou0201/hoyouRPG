package com.isekai.hoyourpg.character.infra.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isekai.hoyourpg.character.domain.job.*;

import java.io.InputStream;
import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

public class JsonJobCatalog implements JobCatalog {

    private final Map<JobId, Job> byId = new HashMap<>();
    private final Map<JobCode, Job> byCode = new HashMap<>();

}

