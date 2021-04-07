package com.tommannson.flagmanager.deploy.process;


import com.tommannson.flagmanager.deploy.Level;
import com.tommannson.flagmanager.error.ResourceNotExistsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface DeployProcessQueryRepository extends JpaRepository<Level, UUID> {

    <T> Page<T> findAllByOwner(String owner, Pageable pageInfo, Class<T> type);

    default Level findByIdRequired(UUID uuid){
        return findById(uuid)
                .orElseThrow(ResourceNotExistsException::new);
    }
}
