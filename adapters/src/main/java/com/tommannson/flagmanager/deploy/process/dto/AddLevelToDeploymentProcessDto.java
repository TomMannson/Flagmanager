package com.tommannson.flagmanager.deploy.process.dto;

import javax.validation.constraints.Pattern;

public class AddLevelToDeploymentProcessDto {

    String name;
    String description;

    @Pattern(regexp = "(project)_[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")
    String owner;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }
}
