package com.tommannson.flagmanager.flags.controller;

import com.tommannson.flagmanager.flags.CodeFlagSnapshot;
import com.tommannson.flagmanager.flags.FlagFacade;
import com.tommannson.flagmanager.flags.FlagRepository;
import com.tommannson.flagmanager.flags.dto.CreateFlagDto;
import com.tommannson.flagmanager.flags.dto.EditFlagDto;
import com.tommannson.flagmanager.flags.dto.ResultFlagDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flags")
public class CodeFlagController {

    private final FlagFacade flagFacade;
    private final FlagRepository flagRepository;


    public CodeFlagController(FlagFacade flagFacade, FlagRepository flagRepository) {
        this.flagFacade = flagFacade;
        this.flagRepository = flagRepository;
    }

    @GetMapping()
    List<ResultFlagDto> findFlags() {
        return flagRepository.findAll()
                .stream()
                .map(value -> new ResultFlagDto(
                        value.getId().toString(),
                        value.getName(),
                        value.getDescription()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping()
    ResponseEntity<?> createFlag(@RequestBody CreateFlagDto dto) {
        UUID id = flagFacade.createFlag(dto.to());
        return ResponseEntity.created(URI.create("/" + id.toString())).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> editFlag(@RequestBody EditFlagDto dto, @PathVariable UUID id) {
        flagFacade.editFlag(id, dto.to());
        return ResponseEntity.ok().build();
    }


}
