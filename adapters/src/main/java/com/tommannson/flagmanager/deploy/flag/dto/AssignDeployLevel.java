package com.tommannson.flagmanager.deploy.flag.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AssignDeployLevel {

    @NotNull
    UUID levelId;

    public UUID getLevelId() {
        return levelId;
    }
}
