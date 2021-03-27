package com.tommannson.flagmanager.deploy.dto;

import java.util.UUID;

public class CreateFeatureDto {

    UUID flagId;
    UUID deployLevel;

    public UUID getFlagId() {
        return flagId;
    }

    public UUID getDeployLevel() {
        return deployLevel;
    }
}
