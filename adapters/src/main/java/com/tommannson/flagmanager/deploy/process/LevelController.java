package com.tommannson.flagmanager.deploy.process;

import com.tommannson.flagmanager.deploy.FeatureFlag;
import com.tommannson.flagmanager.deploy.Level;
import com.tommannson.flagmanager.deploy.process.dto.AddLevelToDeploymentProcessDto;
import com.tommannson.flagmanager.deploy.process.dto.CreateDeploymentProcessDto;
import com.tommannson.flagmanager.deploy.process.dto.LevelQueryDto;
import com.tommannson.flagmanager.error.BindingException;
import com.tommannson.flagmanager.error.ResourceNotExistsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("levels")
public class LevelController {

    public static final String DEFUALT_NAME = "Develop";
    public static final String DEFAULT_DESCRIPTION = "";

    DeployProcessQueryRepository levelRepository;


    public LevelController(DeployProcessQueryRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @GetMapping(params = "ownerId")
    public ResponseEntity<Page<?>> getListOfFlags(@RequestParam String ownerId) {
        return ResponseEntity.ok(levelRepository.findAllByOwner(ownerId, Pageable.unpaged(), LevelQueryDto.class));
    }

    @PostMapping(params = {"createProcess", "!addLevel"})
    public ResponseEntity<?> createLevel(@RequestBody @Valid() CreateDeploymentProcessDto dto, BindingResult binding) {

        if (binding.hasErrors()) {
            throw new BindingException(binding);
        }

        Level level = new Level(UUID.randomUUID(), DEFUALT_NAME, DEFAULT_DESCRIPTION, 0, dto.getOwner());

        level = levelRepository.save(level);
        return ResponseEntity.created(URI.create("/" + level.getId())).build();
    }

    @PostMapping(params = {"addLevel", "!createProcess"})
    public ResponseEntity<?> addLevelTo(@RequestBody @Valid() AddLevelToDeploymentProcessDto dto, BindingResult binding) {

        if (binding.hasErrors()) {
            throw new BindingException(binding);
        }

        int currentOrder = levelRepository.findMaxInOwnerProcess(dto.getOwner());
        Level level = new Level(UUID.randomUUID(), dto.getName(), dto.getDescription(), currentOrder + 1, dto.getOwner());

        levelRepository.save(level);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> addLevelWithIndex(@RequestParam("addLevelAtIndex") int index, @RequestBody @Valid() AddLevelToDeploymentProcessDto dto, BindingResult binding) {

        if (binding.hasErrors()) {
            throw new BindingException(binding);
        }

        List<Level> foundLevels = levelRepository.findAllByOwner(dto.getOwner());
        int currentIndex = index;
        for(Level foundLevel : foundLevels) {
            if (foundLevel.getOrderInProcess() >= index) {
                foundLevel.setOrderInProcess(++currentIndex);
            }
        }

        Level level = new Level(UUID.randomUUID(), dto.getName(), dto.getDescription(), index, dto.getOwner());

        levelRepository.save(level);
        return ResponseEntity.noContent().build();
    }



}
