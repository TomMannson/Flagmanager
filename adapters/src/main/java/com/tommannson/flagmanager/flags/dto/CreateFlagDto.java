package com.tommannson.flagmanager.flags.dto;

import com.tommannson.flagmanager.flags.CodeFlag;

public class CreateFlagDto {

    String name;
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CodeFlag to(){
        return new CodeFlag(name, description);
    }
}
