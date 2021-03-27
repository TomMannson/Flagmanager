package com.tommannson.flagmanager.deploy.dto;

import com.tommannson.flagmanager.deploy.DeployedLevel;

public class ResultDeployLevelDto {

    String id;
    String name;
    String description;

    public ResultDeployLevelDto(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ResultDeployLevelDto() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
