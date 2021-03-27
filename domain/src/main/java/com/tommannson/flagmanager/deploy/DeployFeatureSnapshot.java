package com.tommannson.flagmanager.deploy;

import java.util.UUID;

public class DeployFeatureSnapshot {

    UUID id;
    UUID flagId;
    String flagName;
    String deployLevel;
    String deployName;

    public DeployFeatureSnapshot(UUID id, UUID flagId, String flagName, String deployLevel, String deployName) {
        this.id = id;
        this.flagId = flagId;
        this.flagName = flagName;
        this.deployLevel = deployLevel;
        this.deployName = deployName;
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


    public String getDeployLevel() {
        return deployLevel;
    }

    public String getDeployName() {
        return deployName;
    }

}
