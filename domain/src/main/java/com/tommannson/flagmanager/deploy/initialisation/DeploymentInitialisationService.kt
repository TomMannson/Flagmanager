package com.tommannson.flagmanager.deploy.initialisation

import com.tommannson.flagmanager.deploy.DeployProcess
import com.tommannson.flagmanager.deploy.Environment
import java.util.*

val DEFAULT_DEV_ENVIRONMENT = "DEV"

class DeploymentInitialisationService {
    fun initDeployment(ownerId: UUID) {
        val newCreatedEnvironment: Environment = Environment.create(DEFAULT_DEV_ENVIRONMENT)
        val newDeploymentProcess = DeployProcess.createNew(ownerId, newCreatedEnvironment.id)

        //persistInRepo both aggregates

    }
}