package com.tommannson.flagmanager.deploy;

import com.tommannson.flagmanager.deploy.valueObject.FlagInfoValue;
import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeployableFeatureFacade {

    private final DeployableFeatureRepository featureRepository;
    private final DeployedLevelRepository levelRepository;


    public DeployableFeatureFacade(DeployableFeatureRepository featureRepository, DeployedLevelRepository levelRepository) {
        this.featureRepository = featureRepository;
        this.levelRepository = levelRepository;
    }

    public DeployedLevel createLevel(DeployedLevel flag) {
        return levelRepository.save(flag);
    }

    @Transactional
    public void editLevel(UUID id, DeployedLevel flag) {
        levelRepository.findById(id)
                .map(value -> {
                    value.editWIth(flag);
                    return value;
                })
                .orElseThrow(ResourceNotExistsException::new);
    }

    @Transactional
    public DeployableFeature assignLevelToFeature(FlagInfoValue flagValue, UUID levelId) {
        Optional<DeployableFeature> foundFeature = featureRepository.findByFlagId(UUID.fromString(flagValue.getId()));
        Optional<DeployedLevel> foundLevel = levelRepository.findById(levelId);
        if(!foundLevel.isPresent()){
            throw new ResourceNotExistsException();
        }
        if (foundFeature.isPresent()) {
            DeployableFeature feature = foundFeature.get();
            feature.deployLevel = foundLevel.get();
            return feature;
        } else {
            DeployableFeature newFeature = DeployableFeature.createNew(flagValue, foundLevel.get());
            return featureRepository.save(newFeature);
        }
    }

}
