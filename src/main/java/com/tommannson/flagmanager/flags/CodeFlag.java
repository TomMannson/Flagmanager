package com.tommannson.flagmanager.flags;

import com.tommannson.flagmanager.flags.dto.ResultFlagDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "code_flags")
public class CodeFlag {

    @Id
    UUID id;
    String name;
    String description;

    public CodeFlag(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    protected CodeFlag() {
        //persistence constructor
    }

    public ResultFlagDto getSnapshot(){
        return new ResultFlagDto(this.id.toString(), this.name, this.description);
    }

    public void edit(CodeFlag flag) {
        this.name = flag.name;
        this.description = flag.description;
    }
}
