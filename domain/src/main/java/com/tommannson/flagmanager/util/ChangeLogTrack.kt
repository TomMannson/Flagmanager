package com.tommannson.flagmanager.util

import java.lang.UnsupportedOperationException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty


class TrackablePropertyDelegate<Owner, T>(initialValue: T) : ReadWriteProperty<Owner, T> {
    var curretnValue = initialValue;

    override fun setValue(thisRef: Owner, property: KProperty<*>, value: T) {
        if (thisRef is TrackableAggregate) {
            thisRef.apply(property.name, value)
        } else {
            throw UnsupportedOperationException()
        }

        curretnValue = value;
    }

    override fun getValue(thisRef: Owner, property: KProperty<*>): T {
        return curretnValue
    }

    override fun toString(): String {
        if (curretnValue != null) {
            return curretnValue.toString();
        } else {
            return "null";
        }

    }
}

open class Aggregate {
    internal val changes = mutableMapOf<String, ChangeInfo<*>?>();

    fun <T> assign(setter: KMutableProperty0<T>, value: T){
        setter.set(value)
        changes[setter.name] = ChangeInfo(setter.name, value);
    }

    fun recordedValues():Map<String, ChangeInfo<*>?> = changes;
}

open class TrackableAggregate : Aggregate(){

    fun <Owner, T> track(initialValue: T): TrackablePropertyDelegate<Owner, T> {
        return TrackablePropertyDelegate(initialValue);
    }

    fun <T> apply(propertyName: String, value: T){
        changes[propertyName] = ChangeInfo(propertyName, value);
    }
}

data class ChangeInfo<ValueType>(val propertyName: String, val value: ValueType)

