package com.tommannson.flagmanager.deploy

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "deloyment_level")
class Level(

        @Id val id: UUID,
        val key: String,
        val name: String,
        val description: String,

        @ManyToOne
        @JoinColumn(name="processId", nullable=false)
        val process: DeploymentProcess,
        val ownerId: UUID, //id in remote domain
)