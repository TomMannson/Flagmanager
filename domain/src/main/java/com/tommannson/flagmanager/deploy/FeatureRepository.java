package com.tommannson.flagmanager.deploy;

import java.util.*;

public interface FeatureRepository {

    Set<DeployableFeature> findAllWithLevels(Iterable<UUID> deployLevel);

    Optional<DeployableFeature> findByFlagId(UUID flagId);

    DeployableFeature save(DeployableFeature feature);

    List<DeployableFeature> findAll();
}
