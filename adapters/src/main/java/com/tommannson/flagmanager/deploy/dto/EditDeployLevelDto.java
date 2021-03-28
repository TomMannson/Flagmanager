package com.tommannson.flagmanager.deploy.dto;

import com.tommannson.flagmanager.deploy.DeployedLevelSnapshot;

import java.util.UUID;

public class EditDeployLevelDto {

    String name;
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DeployedLevelSnapshot to(String id){
        return new DeployedLevelSnapshot(UUID.fromString(id), name, description);
    }
}
