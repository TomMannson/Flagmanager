package com.tommannson.flagmanager.flags;

import java.util.List;
import java.util.UUID;

@Deprecated
public interface FlagRepository {

    UUID addFlag(CodeFlag flag);

    void editFlag(CodeFlag flag);

    CodeFlag findFlagById(UUID id);

    List<CodeFlagSnapshot> findAll();
}
