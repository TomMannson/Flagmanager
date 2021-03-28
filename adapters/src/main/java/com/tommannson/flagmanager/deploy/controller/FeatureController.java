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

import java.util.*;
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
                .stream()
                .map(value -> new ResultFeatureDto(
                        value.getId().toString(),
                        value.getFlagId().toString(),
                        value.getFlagName(),
                        value.getDeployLevel().getName(),
                        value.getDeployLevel().getDescription()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
//        return ResponseEntity.ok(new ArrayList<ResultFeatureDto>());
    }

    @GetMapping(params = "!deployLevel")
    ResponseEntity<?> assigneLevelToFlag() {
        List<ResultFeatureDto> result = deployableFeatureRepository.findAll()
                .stream()
                .map(value -> new ResultFeatureDto(value.getId().toString(),
                        value.getFlagId().toString(),
                        value.getFlagName(),
                        value.getDeployLevel().getName(),
                        value.getDeployLevel().getDescription()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/level")
    ResponseEntity<?> assigneLevelToFlag(@RequestBody CreateFeatureDto dto) {
        CodeFlag flag = codeFlagRepository.findFlagById(dto.getFlagId());
        FlagInfoValue value = new FlagInfoValue(flag.getSnapshot());
        deployFacade.assignLevelToFeature(value, dto.getDeployLevel());

        return ResponseEntity.ok().build();
    }
}
