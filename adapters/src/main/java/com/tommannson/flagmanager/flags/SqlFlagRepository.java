package com.tommannson.flagmanager.flags;

import com.tommannson.flagmanager.error.ResourceAlreadyExistsException;
import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface SqlFlagRepository extends JpaRepository<CodeFlagSnapshot, UUID>, FlagRepository {

    default UUID addFlag(CodeFlag flag) {

        CodeFlagSnapshot snapshot = flag.getSnapshot();

        if (existsByName(snapshot.getName())) {
            throw new ResourceAlreadyExistsException();
        }

        save(snapshot);
        return snapshot.getId();
    }

    default void editFlag(CodeFlag flag) {

        CodeFlagSnapshot snapshot = flag.getSnapshot();

        if (existsByIdAndName(snapshot.getId(), snapshot.getName())) {
            throw new ResourceAlreadyExistsException();
        }

        save(snapshot);
    }

    default CodeFlag findFlagById(UUID id){
        Optional<CodeFlagSnapshot> snapshot = findById(id);
        if(snapshot.isPresent()){
            return CodeFlag.restore(snapshot.get());
        } else {
            throw new ResourceNotExistsException();
        }
    }

    boolean existsByName(String name);

    boolean existsByIdAndName(UUID uuid, String name);

}
