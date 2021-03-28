package com.tommannson.flagmanager.deploy;

import java.util.*;

public interface FeatureRepository {

    Set<DeployFeatureSnapshot> findAllWithLevels(Iterable<UUID> deployLevel);

    Optional<DeployableFeature> findFeatureByFlagId(UUID flagId);

    UUID saveFeature(DeployableFeature feature);

    List<DeployFeatureSnapshot> findAll();
}
