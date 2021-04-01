package com.tommannson.flagmanager.deploy

import com.tommannson.flagmanager.util.Aggregate
import com.tommannson.flagmanager.util.ChangeInfo
import java.util.*

typealias FeatureId = String;

class FeatureFlag private constructor(
        private var id: FeatureId,
        private var ownerId: UUID,
        private var key: String,
        private var name: String,
        private var activeOnEnvironment: UUID
): Aggregate() {

    init {
        assign(this::name, "asdasdasd")
    }


    fun promote(){

    }

    fun rollback(){

    }


}
//
//
//class FeatureRecord(var name: String) {
//    fun mapName(record: FeatureRecord, changes: ChangeInfo<*>) {
//        record.name = changes.value as String;
//    }
//}
//
//fun FeatureRecord.applyChanges(changes: Map<String, ChangeInfo<*>>) {
//    changes.forEach { t, u ->
//        when (t) {
//            "name" -> mapName(this, u)
//        }
//    }
//}

