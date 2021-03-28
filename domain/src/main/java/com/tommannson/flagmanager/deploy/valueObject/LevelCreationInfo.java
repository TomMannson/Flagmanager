package com.tommannson.flagmanager.deploy.valueObject;

import com.tommannson.flagmanager.deploy.DeployedLevel;
import com.tommannson.flagmanager.flags.CodeFlagSnapshot;

public class LevelCreationInfo {

    String name;
    String description;

    public LevelCreationInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DeployedLevel create(){
        return DeployedLevel.create(name, description);
    }
}