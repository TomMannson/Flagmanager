package com.tommannson.flagmanager.deploy;

import java.util.UUID;

public class DeployFeatureSnapshot {

    UUID id;
    UUID flagId;
    String flagName;
    DeployedLevelSnapshot deployLevel;

    protected DeployFeatureSnapshot() {
        //persistence constructor
    }

    public DeployFeatureSnapshot(UUID id, UUID flagId, String flagName, DeployedLevelSnapshot deployLevel) {
        this.id = id;
        this.flagId = flagId;
        this.flagName = flagName;
        this.deployLevel = deployLevel;
    }

    public UUID getId() {
        return id;
    }

    public UUID getFlagId() {
        return flagId;
    }

    public String getFlagName() {
        return flagName;
    }

    public DeployedLevelSnapshot getDeployLevel() {
        return deployLevel;
    }
}
