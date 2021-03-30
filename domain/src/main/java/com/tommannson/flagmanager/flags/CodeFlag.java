package com.tommannson.flagmanager.flags;

import com.tommannson.flagmanager.flags.valueobject.CodeFlagChanges;

import java.util.UUID;

@Deprecated
public class CodeFlag {

    UUID id;
    String name;
    String description;

    public static CodeFlag create(String name, String description){
        return new CodeFlag(name, description);
    }

    public static CodeFlag restore(CodeFlagSnapshot snapshot) {
        CodeFlag flag = new CodeFlag();

        flag.id = snapshot.getId();
        flag.name = snapshot.getName();
        flag.description = snapshot.getDescription();

        return flag;
    }

    public CodeFlag(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    protected CodeFlag() {
        //persistence constructor
    }

    public CodeFlagSnapshot getSnapshot() {
        return new CodeFlagSnapshot(this.id, this.name, this.description);
    }

    public void edit(CodeFlagChanges flag) {
        this.name = flag.getName();
        this.description = flag.getDescription();
    }
}
