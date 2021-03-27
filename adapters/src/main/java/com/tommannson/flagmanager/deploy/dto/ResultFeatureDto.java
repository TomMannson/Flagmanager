package com.tommannson.flagmanager.deploy.dto;

public class ResultFeatureDto {

    String id;
    String flagId;
    String flagName;
    String deployLevel;
    String deployName;

    public ResultFeatureDto(String id, String flagId, String flagName, String deployLevel, String deployName) {
        this.id = id;
        this.flagId = flagId;
        this.flagName = flagName;
        this.deployLevel = deployLevel;
        this.deployName = deployName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public String getDeployLevel() {
        return deployLevel;
    }

    public void setDeployLevel(String deployLevel) {
        this.deployLevel = deployLevel;
    }

    public String getDeployName() {
        return deployName;
    }

    public void setDeployName(String deployName) {
        this.deployName = deployName;
    }
}
