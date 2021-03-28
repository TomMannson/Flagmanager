package com.tommannson.flagmanager.deploy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

interface SqlFeatureRepository extends JpaRepository<DeployFeatureSnapshot, UUID>, FeatureRepository {

    @Query("from DeployFeatureSnapshot feature join fetch feature.deployLevel where feature.deployLevel.id in :deployLevel")
    Set<DeployFeatureSnapshot> findAllWithLevels(Iterable<UUID> deployLevel);

    Optional<DeployFeatureSnapshot> findByFlagId(UUID flagId);

    default Optional<DeployableFeature> findFeatureByFlagId(UUID flagId) {
        return findByFlagId(flagId)
                .map(DeployableFeature::restore);
    }

    default UUID saveFeature(DeployableFeature feature){
        return save(feature.toSnapshot()).getId();
    }

}


