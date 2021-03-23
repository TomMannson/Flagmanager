package com.tommannson.flagmanager.flags.controller;

import com.tommannson.flagmanager.flags.CodeFlag;
import com.tommannson.flagmanager.flags.CodeFlagRepository;
import com.tommannson.flagmanager.flags.FlagFacade;
import com.tommannson.flagmanager.flags.dto.CreateFlagDto;
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
    private final CodeFlagRepository flagRepository;


    public CodeFlagController(FlagFacade flagFacade, CodeFlagRepository flagRepository) {
        this.flagFacade = flagFacade;
        this.flagRepository = flagRepository;
    }

    @GetMapping()
    List<ResultFlagDto> findFlags(){
        return flagRepository.findAll().stream().map(CodeFlag::getSnapshot).collect(Collectors.toList());
    }

    @PostMapping()
    ResponseEntity<?> createFlag(@RequestBody CreateFlagDto dto){
        ResultFlagDto result = flagFacade.createFlag(dto.to()).getSnapshot();
        return ResponseEntity.created(URI.create("/" + result.getId())).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> createFlag(@RequestBody CreateFlagDto dto, @PathVariable UUID id){
        ResultFlagDto result = flagFacade.editFlag(id, dto.to()).getSnapshot();
        return ResponseEntity.ok().build();
    }


}
