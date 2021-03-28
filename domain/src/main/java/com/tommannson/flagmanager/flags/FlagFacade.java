package com.tommannson.flagmanager.flags;

import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlagFacade {

    private final FlagRepository flagRepository;

    FlagFacade(FlagRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    public CodeFlag createFlag(CodeFlag flag) {
        return flagRepository.save(flag);
    }

    @Transactional
    public void editFlag(UUID id, CodeFlag flag) {
        flagRepository.findById(id)
                .map(loadedValue -> {
                    loadedValue.edit(flag);
                    return loadedValue;
                }).orElseThrow(ResourceNotExistsException::new);
    }

}
