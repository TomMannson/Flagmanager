package com.tommannson.flagmanager.deploy;

import com.tommannson.flagmanager.deploy.dto.ResultFeatureDto;

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

    static DeployableFeature createNew(UUID flagId, DeployedLevel deployLevel){
        DeployableFeature feature = new DeployableFeature();
        feature.id = UUID.randomUUID();
        feature.deployLevel = deployLevel;
        feature.flagId = flagId;
        feature.flagName = "FLAG_NAME";
        return feature;
    }

    public ResultFeatureDto toSnapshot(){
        return new ResultFeatureDto(
                id.toString(),
                flagId.toString(),
                flagName,
                deployLevel.name,
                deployLevel.description
        );
    }
}
