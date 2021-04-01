package com.tommannson.flagmanager.deploy

import java.util.*

typealias EnvironmentId = UUID

val DEFAULT_EMPTY_DESCRIPTION = "";

class Environment private constructor(
        val id: EnvironmentId,
        private var name: Name,
        private var description: String,
) {

    fun assignName(name: String) {
        this.name = Name(name)
    }

    fun assignDescription(description: String) {
        this.description = description
    }



    companion object {
        fun create(name: String) = Environment(
                UUID.randomUUID(),
                Name(name),
                DEFAULT_EMPTY_DESCRIPTION,
        )
    }

    class Name(name:String) {

        val name: String

        init {
            //throw if empty
            this.name = name
        }
    }
}