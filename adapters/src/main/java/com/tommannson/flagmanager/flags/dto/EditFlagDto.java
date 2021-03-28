package com.tommannson.flagmanager.flags.dto;

import com.tommannson.flagmanager.flags.valueobject.CodeFlagChanges;

public class EditFlagDto {

    String name;
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CodeFlagChanges to() {
        return CodeFlagChanges.create(name, description);
    }
}
