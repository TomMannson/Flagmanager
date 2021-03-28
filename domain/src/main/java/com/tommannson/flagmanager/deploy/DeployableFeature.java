package com.tommannson.flagmanager.deploy;

import com.tommannson.flagmanager.deploy.valueObject.FlagInfoValue;

import java.util.UUID;


public class DeployableFeature {

    UUID id;
    UUID flagId;
    String flagName;
    DeployedLevel deployLevel;

    static DeployableFeature createNew(FlagInfoValue flagValue, DeployedLevelSnapshot deployLevel){
        DeployableFeature feature = new DeployableFeature();
        feature.id = UUID.randomUUID();
        feature.deployLevel = DeployedLevel.restore(deployLevel);
        feature.flagId = UUID.fromString(flagValue.getId());
        feature.flagName = flagValue.getName();
        return feature;
    }

    static DeployableFeature restore(DeployFeatureSnapshot snapshot){
        DeployableFeature feature = new DeployableFeature();
        feature.id = snapshot.getId();
        feature.deployLevel = DeployedLevel.restore(snapshot.getDeployLevel());
        feature.flagId = snapshot.getFlagId();
        feature.flagName = snapshot.getFlagName();
        return feature;
    }

    public DeployFeatureSnapshot toSnapshot(){
        return new DeployFeatureSnapshot(
                id,
                flagId,
                flagName,
                deployLevel.toSnapshot()
        );
    }
}
