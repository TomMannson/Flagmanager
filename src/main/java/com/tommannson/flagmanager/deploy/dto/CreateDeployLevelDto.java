package com.tommannson.flagmanager.deploy.dto;

import com.tommannson.flagmanager.deploy.DeployedLevel;
import com.tommannson.flagmanager.flags.CodeFlag;

public class CreateDeployLevelDto {

    String name;
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DeployedLevel to(){
        return new DeployedLevel(name, description);
    }
}
