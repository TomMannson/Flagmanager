package com.tommannson.flagmanager.deploy.controller;

import com.tommannson.flagmanager.deploy.*;
import com.tommannson.flagmanager.deploy.dto.CreateDeployLevelDto;
import com.tommannson.flagmanager.deploy.dto.EditDeployLevelDto;
import com.tommannson.flagmanager.deploy.dto.ResultDeployLevelDto;
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
    private final LevelRepository deployedLevelRepository;


    public DeployLevelController(DeployableFeatureFacade deployFacade, LevelRepository deployedLevelRepository) {
        this.deployFacade = deployFacade;
        this.deployedLevelRepository = deployedLevelRepository;
    }

    @GetMapping()
    List<ResultDeployLevelDto> findLevels(){
        return deployedLevelRepository.findAll()
                .stream()
                .map(value -> new ResultDeployLevelDto(
                        value.getId().toString(),
                        value.getName(),
                        value.getDescription())
                )
                .collect(Collectors.toList());
    }

    @PostMapping()
    ResponseEntity<?> createLevel(@RequestBody CreateDeployLevelDto dto){
        UUID id = deployFacade.createLevel(dto.to());
        return ResponseEntity.created(URI.create("/" + id.toString())).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> editLevel(@RequestBody EditDeployLevelDto dto, @PathVariable UUID id){
        deployFacade.editLevel(id, dto.to(id.toString()));
        return ResponseEntity.ok().build();
    }


}
