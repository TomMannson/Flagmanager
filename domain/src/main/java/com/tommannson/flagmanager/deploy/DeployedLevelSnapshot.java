package com.tommannson.flagmanager.deploy;

import java.util.UUID;

public class DeployedLevelSnapshot {

    UUID id;
    String name;
    String description;

    protected DeployedLevelSnapshot() {
        //persistence constructor
    }

    public DeployedLevelSnapshot(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
