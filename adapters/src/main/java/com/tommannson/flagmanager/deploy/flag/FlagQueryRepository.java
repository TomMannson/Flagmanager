package com.tommannson.flagmanager.deploy.flag;

import com.tommannson.flagmanager.deploy.FeatureFlag;
import com.tommannson.flagmanager.deploy.flag.dto.FlagQueryDto;
import com.tommannson.flagmanager.error.ResourceNotExistsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface FlagQueryRepository extends JpaRepository<FeatureFlag, UUID> {

    Page<FlagQueryDto> findAllByOwner(String owner, Pageable pageInfo);

    boolean existsByNameAndOwner(String name, String owner);

    default FeatureFlag findByIdRequired(UUID uuid){
        return findById(uuid)
                .orElseThrow(ResourceNotExistsException::new);
    }


}
