package com.tommannson.flagmanager.deploy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SqlLevelRepository extends JpaRepository<DeployedLevel, UUID>, LevelRepository {

}
