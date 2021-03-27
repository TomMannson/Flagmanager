package com.tommannson.flagmanager.deploy;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface LevelRepository {

    List<DeployedLevel> findAll();

    DeployedLevel save(DeployedLevel feature);

    Optional<DeployedLevel> findById(UUID id);
}
