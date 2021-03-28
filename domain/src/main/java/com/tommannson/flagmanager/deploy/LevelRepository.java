package com.tommannson.flagmanager.deploy;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface LevelRepository {

    List<DeployedLevelSnapshot> findAll();

    UUID saveLevel(DeployedLevel feature);

    DeployedLevel findLevelById(UUID id);
}
