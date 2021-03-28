package com.tommannson.flagmanager.deploy;

import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface SqlLevelRepository extends JpaRepository<DeployedLevelSnapshot, UUID>, LevelRepository {

    default DeployedLevel findLevelById(UUID id) {
        Optional<DeployedLevelSnapshot> snapshot = findById(id);
        if(!snapshot.isPresent()){
            throw new ResourceNotExistsException();
        }

        return DeployedLevel.restore(snapshot.get());
    }

    default UUID saveLevel(DeployedLevel level){
        return save(level.toSnapshot()).getId();
    }

}
