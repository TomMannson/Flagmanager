package com.tommannson.flagmanager.deploy;

import com.tommannson.flagmanager.deploy.valueObject.FlagInfoValue;
import com.tommannson.flagmanager.deploy.valueObject.LevelCreationInfo;
import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeployableFeatureFacade {

    private final FeatureRepository featureRepository;
    private final LevelRepository levelRepository;

    public DeployableFeatureFacade(FeatureRepository featureRepository, LevelRepository levelRepository) {
        this.featureRepository = featureRepository;
        this.levelRepository = levelRepository;
    }

    public UUID createLevel(LevelCreationInfo creationInfo) {
        return levelRepository.saveLevel(creationInfo.create());
    }

    @Transactional
    public void editLevel(UUID id, DeployedLevelSnapshot flag) {
        DeployedLevel level = levelRepository.findLevelById(id);
        level.editWIth(flag);
    }

    @Transactional
    public void assignLevelToFeature(FlagInfoValue flagValue, UUID levelId) {
        Optional<DeployableFeature> foundFeature = featureRepository.findFeatureByFlagId(UUID.fromString(flagValue.getId()));
        DeployedLevel foundLevel = levelRepository.findLevelById(levelId);

        if (foundFeature.isPresent()) {
            DeployableFeature feature = foundFeature.get();
            feature.deployLevel = foundLevel;
            featureRepository.saveFeature(feature);
        } else {
            DeployableFeature created = DeployableFeature.createNew(flagValue, foundLevel.toSnapshot());
            featureRepository.saveFeature(created);
        }
    }

}
