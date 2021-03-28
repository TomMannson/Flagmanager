package com.tommannson.flagmanager.deploy;

import java.util.UUID;


public class DeployedLevel {

    UUID id;
    String name;
    String description;

    public static DeployedLevel create(String name, String description){
        return new DeployedLevel(UUID.randomUUID(), name, description);
    }

    private DeployedLevel(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void editWIth(DeployedLevelSnapshot flag) {
        name = flag.name;
        description = flag.description;
    }

    public DeployedLevelSnapshot toSnapshot(){
        return new DeployedLevelSnapshot(id, name, description);
    }

    public static DeployedLevel restore(DeployedLevelSnapshot deployedLevelSnapshot) {
        return new DeployedLevel(deployedLevelSnapshot.getId(), deployedLevelSnapshot.getName(), deployedLevelSnapshot.getDescription());
    }
}
