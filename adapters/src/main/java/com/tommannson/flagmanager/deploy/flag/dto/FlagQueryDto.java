package com.tommannson.flagmanager.deploy.flag.dto;

import com.tommannson.flagmanager.deploy.process.dto.LevelQueryDto;

import java.util.UUID;

//public class FlagQueryDto {
public interface FlagQueryDto {

//    UUID id;
//    String name, key, description;
//    LevelQueryDto assignedLevel;
//
//    public FlagQueryDto(UUID id, String name, String key, String description, LevelQueryDto assignedLevel) {
//        this.id = id;
//        this.name = name;
//        this.key = key;
//        this.description = description;
//        this.assignedLevel = assignedLevel;
//    }

    UUID getId();
//    public UUID getId() {
//        return id;
//    }

     String getName();
//    public String getName() {
//        return name;
//    }

    public String getKey();
//    public String getKey() {
//        return key;
//    }

    public String getDescription();
//    public String getDescription() {
//        return description;
//    }

    LevelSummary getAssignedLevel();

    interface LevelSummary {
        String getName();
    }


}
