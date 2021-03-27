package com.tommannson.flagmanager.deploy.valueObject;

import com.tommannson.flagmanager.flags.CodeFlagSnapshot;

public class FlagInfoValue {

    String id;
    String name;
    String description;

    public FlagInfoValue(CodeFlagSnapshot value) {
        this.id = value.getId().toString();
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