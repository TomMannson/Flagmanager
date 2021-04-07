package com.tommannson.flagmanager.deploy

import java.util.*
import javax.persistence.*

@Entity
@Table(
        name = "feature_flag",
        uniqueConstraints = arrayOf(
                UniqueConstraint(columnNames = arrayOf("owner", "name"))
        ),
)
class FeatureFlag(

        @Id val id: UUID,
        var key: String,
        var name: String,
        var description: String,

        @ManyToOne
        @JoinColumn(name = "levelId")
        var assignedLevel: Level?,

        val owner: String, //id in remote domain
)