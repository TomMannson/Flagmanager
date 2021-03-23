package com.tommannson.flagmanager.deploy;

import com.tommannson.flagmanager.flags.CodeFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface DeployableFeatureRepository extends JpaRepository<DeployableFeature, UUID> {

    @Query("from DeployableFeature feature join fetch feature.deployLevel where feature.deployLevel.id in :deployLevel")
    Set<DeployableFeature> findAllWithLevels(Iterable<UUID> deployLevel);

    Optional<DeployableFeature> findByFlagId(UUID flagId);

}
