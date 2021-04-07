package com.tommannson.flagmanager.deploy

import java.util.*
import javax.persistence.*

@Entity
@Table(
        name = "deloyment_level",
        uniqueConstraints = arrayOf(
                UniqueConstraint(columnNames = arrayOf("owner", "name"))
        ),
)
class Level(

        @Id val id: UUID,
        val name: String,
        val description: String,
        @Column(nullable = false)
        val orderInProcess: Int,

        val owner: String, //id in remote domain
)