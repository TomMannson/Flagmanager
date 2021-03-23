package com.tommannson.flagmanager.deploy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface DeployedLevelRepository extends JpaRepository<DeployedLevel, UUID> {

}
