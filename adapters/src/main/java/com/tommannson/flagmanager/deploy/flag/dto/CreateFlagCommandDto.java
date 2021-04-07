package com.tommannson.flagmanager.deploy.flag.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

public class CreateFlagCommandDto {

    @NotBlank
    private String name;
    @NotNull
    private String description;

    @Pattern(regexp = "(project)_[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")
    private String owner;

    public CreateFlagCommandDto() {
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getTarget() {
        return owner.split("_")[0];
    }

    public UUID getOwnerId() {
        return UUID.fromString(owner.split("_")[1]);
    }
}
