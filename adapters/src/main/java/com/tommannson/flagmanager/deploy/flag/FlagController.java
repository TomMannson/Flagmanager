package com.tommannson.flagmanager.deploy.flag;

import com.tommannson.flagmanager.deploy.FeatureFlag;
import com.tommannson.flagmanager.deploy.Level;
import com.tommannson.flagmanager.deploy.flag.dto.AssignDeployLevel;
import com.tommannson.flagmanager.deploy.flag.dto.CreateFlagCommandDto;
import com.tommannson.flagmanager.deploy.process.DeployProcessQueryRepository;
import com.tommannson.flagmanager.error.BindingException;
import com.tommannson.flagmanager.error.InvalidOperationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("flags")
public class FlagController {

    FlagQueryRepository queryRepository;
    DeployProcessQueryRepository levelRepository;

    public FlagController(FlagQueryRepository queryRepository, DeployProcessQueryRepository levelRepository) {
        this.queryRepository = queryRepository;
        this.levelRepository = levelRepository;
    }

    @GetMapping(params = "!levelId")
    public ResponseEntity<Page<?>> getListOfFlags(@RequestParam String ownerId) {
        return ResponseEntity.ok(queryRepository.findAllByOwner(ownerId, Pageable.unpaged()));
    }

    @GetMapping
    public ResponseEntity<Page<?>> getListOfFlagsByLevel(@RequestParam String ownerId, @RequestParam UUID levelId) {
        Level level = levelRepository.findByIdRequired(levelId);
        return ResponseEntity.ok(queryRepository.findByOwnerAndOrder(ownerId, level.getOrderInProcess(), Pageable.unpaged()));
    }

    @PostMapping(params = {"create", "!assignLevel"})
    public ResponseEntity<?> createFlag(@RequestBody @Valid() CreateFlagCommandDto dto, BindingResult binding) {

        if (binding.hasErrors()) {
            throw new BindingException(binding);
        }

        FeatureFlag featureToCreate = new FeatureFlag(
                UUID.randomUUID(),
                convertToSnakeCase(dto.getName()),
                dto.getName(),
                dto.getDescription(),
                null,
                dto.getOwner()
        );
        featureToCreate = queryRepository.save(featureToCreate);
        return ResponseEntity.created(URI.create("/" + featureToCreate.getId())).build();
    }

    @PostMapping(value = "/{id}", params = {"assignLevel"})
    public ResponseEntity<?> assignDeloyLevel(
            @PathVariable("id") UUID flagId,
            @RequestBody @Valid() AssignDeployLevel dto, BindingResult binding) {

        if (binding.hasErrors()) {
            throw new BindingException(binding);
        }

        Level level = levelRepository.findByIdRequired(dto.getLevelId());
        FeatureFlag flag = queryRepository.findByIdRequired(flagId);

        if (!flag.getOwner().equals(level.getOwner())) {
            throw new InvalidOperationException("invalid_ownerId");
        }

        flag.setAssignedLevel(level);

        queryRepository.save(flag);
        return ResponseEntity.noContent().build();
    }


    String convertToSnakeCase(String input) {
        return input.replaceAll(" ", "_").toLowerCase();
    }
}
