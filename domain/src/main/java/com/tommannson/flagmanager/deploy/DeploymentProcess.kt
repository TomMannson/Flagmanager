package com.tommannson.flagmanager.deploy

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "deployment_process")
class DeploymentProcess(
        @Id val id: UUID,

        @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "process", fetch = FetchType.EAGER)
        val listOfLevelOnProcess: Set<Level>
)