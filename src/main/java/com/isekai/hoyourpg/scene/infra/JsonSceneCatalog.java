package com.isekai.hoyourpg.scene.infra;

import com.isekai.hoyourpg.scene.domain.*;

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSceneCatalog implements SceneCatalog{

    private final Map<SceneId, Scene> byId = new HashMap<>();

    public JsonSceneCatalog(SceneLoader loader, ObjectMapper mapper){
        ClassLoader cl = getClass().getClassLoader();

        try (InputStream indexIn = cl.getResourceAsStream("scenes/index.json")) {
            SceneIndex index = mapper.readValue(indexIn, SceneIndex.class);
            if (indexIn == null) {
                throw new IllegalStateException("Scene index json not found: scenes/index.json");
            }
            for (String file : index.files()) {
                try (InputStream in = cl.getResourceAsStream("scenes/" + file)) {
                    if(in == null){
                        throw new IllegalStateException("Scene json not found: " + file);
                    }
                    Scene scene = loader.load(in);
                    byId.put(scene.id(), scene);
                }
                catch (IOException e) {
                    throw new IllegalStateException("Failed to load scene json: " + file, e);
                }

            }
        }
        catch (IOException e) {
            throw new IllegalStateException("Failed to load scene index json: ", e);
        }
    }

    @Override
    public Scene findById(SceneId id){
        Scene scene = byId.get(id);
        if (scene == null) {
            throw new IllegalArgumentException("Unknown Scene Id: " + id);
        }
        return scene;
    }
}