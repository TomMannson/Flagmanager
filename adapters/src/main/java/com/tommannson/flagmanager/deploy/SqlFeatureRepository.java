package com.tommannson.flagmanager.deploy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

interface SqlFeatureRepository extends JpaRepository<DeployableFeature, UUID>, FeatureRepository {

    @Query("from DeployableFeature feature join fetch feature.deployLevel where feature.deployLevel.id in :deployLevel")
    Set<DeployableFeature> findAllWithLevels(Iterable<UUID> deployLevel);

    Optional<DeployableFeature> findByFlagId(UUID flagId);

}
