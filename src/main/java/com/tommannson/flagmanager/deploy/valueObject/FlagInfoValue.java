package com.tommannson.flagmanager.deploy.valueObject;

import com.tommannson.flagmanager.flags.dto.ResultFlagDto;

public class FlagInfoValue {

    String id;
    String name;
    String description;

    public FlagInfoValue(ResultFlagDto value) {
        this.id = value.getId();
        this.name = value.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}