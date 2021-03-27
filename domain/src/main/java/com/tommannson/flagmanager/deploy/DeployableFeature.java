package com.tommannson.flagmanager.deploy;
import com.tommannson.flagmanager.deploy.valueObject.FlagInfoValue;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "deployable_features")
public class DeployableFeature {

    @Id
    UUID id;

    UUID flagId; //dataReplication
    String flagName; //dataReplication

    @ManyToOne
    @JoinColumn(name = "deployed_level_id")
    DeployedLevel deployLevel;

    static DeployableFeature createNew(FlagInfoValue flagValue, DeployedLevel deployLevel){
        DeployableFeature feature = new DeployableFeature();
        feature.id = UUID.randomUUID();
        feature.deployLevel = deployLevel;
        feature.flagId = UUID.fromString(flagValue.getId());
        feature.flagName = flagValue.getName();
        return feature;
    }

    public DeployFeatureSnapshot toSnapshot(){
        return new DeployFeatureSnapshot(
                id,
                flagId,
                flagName,
                deployLevel.name,
                deployLevel.description
        );
    }
}
