package com.tommannson.flagmanager.deploy.controller;

import com.tommannson.flagmanager.deploy.DeployableFeature;
import com.tommannson.flagmanager.deploy.DeployableFeatureFacade;
import com.tommannson.flagmanager.deploy.DeployableFeatureRepository;
import com.tommannson.flagmanager.deploy.DeployedLevel;
import com.tommannson.flagmanager.deploy.dto.CreateDeployLevelDto;
import com.tommannson.flagmanager.deploy.dto.CreateFeatureDto;
import com.tommannson.flagmanager.deploy.dto.ResultDeployLevelDto;
import com.tommannson.flagmanager.deploy.dto.ResultFeatureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deploy")
public class FeatureController {

    private final DeployableFeatureFacade deployFacade;
    private final DeployableFeatureRepository deployableFeatureRepository;


    public FeatureController(DeployableFeatureFacade deployFacade, DeployableFeatureRepository deployableFeatureRepository) {
        this.deployFacade = deployFacade;
        this.deployableFeatureRepository = deployableFeatureRepository;
    }

    @GetMapping
    ResponseEntity<?> assigneLevelToFlag(){
        List<ResultFeatureDto> result = deployableFeatureRepository.findAll()
                .stream().map(DeployableFeature::toSnapshot)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/level")
    ResponseEntity<?> assigneLevelToFlag(@RequestBody CreateFeatureDto dto){
        UUID flagId = UUID.fromString(dto.getFlagId());
        UUID levelId = UUID.fromString(dto.getDeployLevel());
        deployFacade.assignLevelToFeature(flagId, levelId).toSnapshot();
        return ResponseEntity.ok().build();
    }
}
