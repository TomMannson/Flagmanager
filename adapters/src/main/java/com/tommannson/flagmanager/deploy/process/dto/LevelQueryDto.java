package com.tommannson.flagmanager.deploy.process.dto;

import java.util.UUID;

public class LevelQueryDto {

    UUID id;
    String name, description;

    public LevelQueryDto(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
