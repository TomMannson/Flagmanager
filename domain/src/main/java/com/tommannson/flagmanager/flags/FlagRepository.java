package com.tommannson.flagmanager.flags;

import com.tommannson.flagmanager.deploy.DeployedLevel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlagRepository {

    CodeFlag save(CodeFlag feature);

    Optional<CodeFlag> findById(UUID id);

    List<CodeFlag> findAll();
}
