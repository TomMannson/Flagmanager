package com.tommannson.flagmanager.deploy.flag.dto;

import com.tommannson.flagmanager.deploy.process.dto.LevelQueryDto;

import java.util.UUID;

public interface FlagQueryDto {

    UUID getId();

     String getName();

    String getKey();

    String getDescription();

    LevelSummary getAssignedLevel();

    interface LevelSummary {
        String getName();
    }
}
