package com.tommannson.flagmanager.deploy.controller;

import com.tommannson.flagmanager.deploy.DeployableFeature;
import com.tommannson.flagmanager.deploy.DeployableFeatureFacade;
import com.tommannson.flagmanager.deploy.FeatureRepository;
import com.tommannson.flagmanager.deploy.dto.CreateFeatureDto;
import com.tommannson.flagmanager.deploy.dto.ResultFeatureDto;
import com.tommannson.flagmanager.deploy.valueObject.FlagInfoValue;
import com.tommannson.flagmanager.flags.CodeFlag;
import com.tommannson.flagmanager.flags.FlagRepository;
import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deploy")
public class FeatureController {

    private final DeployableFeatureFacade deployFacade;
    private final FeatureRepository deployableFeatureRepository;
    private final FlagRepository codeFlagRepository;


    public FeatureController(DeployableFeatureFacade deployFacade,
                             FeatureRepository featureRepository,
                             FlagRepository codeFlagRepository) {
        this.deployFacade = deployFacade;
        this.deployableFeatureRepository = featureRepository;
        this.codeFlagRepository = codeFlagRepository;
    }

    @GetMapping
    ResponseEntity<?> findAllFeaturesWithDeployLevel(@RequestParam(name = "deployLevel") String deployLevel) {
        Set<UUID> uuids = Collections.singleton(UUID.fromString(deployLevel));
        List<ResultFeatureDto> result = deployableFeatureRepository.findAllWithLevels(uuids)
                .stream().map(DeployableFeature::toSnapshot)
                .map(value -> new ResultFeatureDto(value.getId().toString(),
                        value.getFlagId().toString(),
                        value.getFlagName(),
                        value.getDeployLevel(),
                        value.getDeployName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(params = "!deployLevel")
    ResponseEntity<?> assigneLevelToFlag() {
        List<ResultFeatureDto> result = deployableFeatureRepository.findAll()
                .stream()
                .map(DeployableFeature::toSnapshot)
                .map(value -> new ResultFeatureDto(value.getId().toString(),
                        value.getFlagId().toString(),
                        value.getFlagName(),
                        value.getDeployLevel(),
                        value.getDeployName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/level")
    ResponseEntity<?> assigneLevelToFlag(@RequestBody CreateFeatureDto dto) {
        codeFlagRepository.findById(dto.getFlagId())
                .map(CodeFlag::getSnapshot)
                .map(FlagInfoValue::new)
                .map(flagValue -> deployFacade.assignLevelToFeature(flagValue, dto.getDeployLevel()))
                .orElseThrow(ResourceNotExistsException::new);

        return ResponseEntity.ok().build();
    }
}
