package com.tommannson.flagmanager.deploy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "deployed_levels")
public class DeployedLevel {

    @Id
    UUID id;

    String name;
    String description;

    public DeployedLevel(String name, String description) {
        id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    protected DeployedLevel() {
        //persistence constructor
    }

    public DeployedLevelSnapshot toSnapshot(){
        return new DeployedLevelSnapshot(id, name, description);
    }

    public void editWIth(DeployedLevel flag) {
        name = flag.name;
        description = flag.description;
    }
}
