package com.tommannson.flagmanager.deploy

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feature_flag")
class FeatureFlag(

        @Id val id: UUID,
        val key: String,
        val name: String,
        val description: String,

        @ManyToOne
        @JoinColumn(name = "levelId")
        val assignedLevel: Level?,
        val ownerId: UUID, //id in remote domain
)