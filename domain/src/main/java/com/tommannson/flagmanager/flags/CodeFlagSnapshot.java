package com.tommannson.flagmanager.flags;


import java.util.UUID;

public class CodeFlagSnapshot {

    private UUID id;
    private String name;
    private String description;

    protected CodeFlagSnapshot() {
        //persistence
    }

    public CodeFlagSnapshot(UUID id, String name, String description) {
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
