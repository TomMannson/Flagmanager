package com.tommannson.flagmanager.flags;

import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlagFacade {

    private final CodeFlagRepository repository;

    FlagFacade(CodeFlagRepository repository) {
        this.repository = repository;
    }

    public CodeFlag createFlag(CodeFlag flag) {
        return repository.save(flag);
    }

    @Transactional
    public CodeFlag editFlag(UUID id, CodeFlag flag) {
        return repository.findById(id)
                .map(loadedValue -> {
                    loadedValue.edit(flag);
                    return loadedValue;
                }).orElseThrow(ResourceNotExistsException::new);
    }

}
