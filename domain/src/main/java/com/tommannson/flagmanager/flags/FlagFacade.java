package com.tommannson.flagmanager.flags;

import com.tommannson.flagmanager.flags.valueobject.CodeFlagChanges;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Deprecated
public class FlagFacade {

    private final FlagRepository flagRepository;

    FlagFacade(FlagRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    public UUID createFlag(CodeFlag flag) {
        return flagRepository.addFlag(flag);
    }

    @Transactional
    public void editFlag(UUID id, CodeFlagChanges flagChanges) {
        CodeFlag flag = flagRepository.findFlagById(id);
        flag.edit(flagChanges);
        flagRepository.editFlag(flag);
    }

}
