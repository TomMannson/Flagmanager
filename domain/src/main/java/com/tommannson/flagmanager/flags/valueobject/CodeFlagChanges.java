package com.tommannson.flagmanager.flags.valueobject;

import com.tommannson.flagmanager.flags.CodeFlagSnapshot;

import java.util.UUID;

public class CodeFlagChanges {

    String name;
    String description;

    public static CodeFlagChanges create(String name, String description){
        return new CodeFlagChanges(name, description);
    }

    CodeFlagChanges(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
