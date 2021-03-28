package com.tommannson.flagmanager.deploy.dto;

import com.tommannson.flagmanager.deploy.DeployedLevel;
import com.tommannson.flagmanager.deploy.DeployedLevelSnapshot;
import com.tommannson.flagmanager.deploy.valueObject.LevelCreationInfo;

public class CreateDeployLevelDto {

    String name;
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LevelCreationInfo to(){
        return new LevelCreationInfo(name, description);
    }
}
