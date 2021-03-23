package com.tommannson.flagmanager.deploy.controller;

import com.tommannson.flagmanager.deploy.DeployableFeatureFacade;
import com.tommannson.flagmanager.deploy.DeployedLevel;
import com.tommannson.flagmanager.deploy.DeployedLevelRepository;
import com.tommannson.flagmanager.deploy.dto.CreateDeployLevelDto;
import com.tommannson.flagmanager.deploy.dto.ResultDeployLevelDto;
import com.tommannson.flagmanager.flags.CodeFlag;
import com.tommannson.flagmanager.flags.dto.CreateFlagDto;
import com.tommannson.flagmanager.flags.dto.ResultFlagDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/levels")
public class DeployLevelController {

    private final DeployableFeatureFacade deployFacade;
    private final DeployedLevelRepository deployedLevelRepository;


    public DeployLevelController(DeployableFeatureFacade deployFacade, DeployedLevelRepository deployedLevelRepository) {
        this.deployFacade = deployFacade;
        this.deployedLevelRepository = deployedLevelRepository;
    }

    @GetMapping()
    List<ResultDeployLevelDto> findLevels(){
        return deployedLevelRepository.findAll()
                .stream()
                .map(DeployedLevel::toSnapshot)
                .collect(Collectors.toList());
    }

    @PostMapping()
    ResponseEntity<?> createLevel(@RequestBody CreateDeployLevelDto dto){
        ResultDeployLevelDto result = deployFacade.createLevel(dto.to()).toSnapshot();
        return ResponseEntity.created(URI.create("/" + result.getId())).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> createFlag(@RequestBody CreateDeployLevelDto dto, @PathVariable UUID id){
        deployFacade.editLevel(id, dto.to());
        return ResponseEntity.ok().build();
    }


}
