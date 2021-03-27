package com.tommannson.flagmanager.flags;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SqlFlagRepository extends JpaRepository<CodeFlag, UUID>, FlagRepository {
}
