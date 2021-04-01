package com.tommannson.flagmanager.deploy

import java.util.*
import javax.persistence.Entity

@Entity
class DeployProcess private constructor(
        private val id: UUID,
        private var ownerId: UUID,
        private var levelsOnProcess: MutableList<EnvironmentId>,
)

class DeployProcessSnapshot {

}
