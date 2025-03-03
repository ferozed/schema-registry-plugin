package com.github.imflog.schema.registry

import io.confluent.kafka.schemaregistry.client.rest.entities.SchemaReference

data class Subject(
    val inputSubject: String,
    val file: String,
    val type: String
) {
    val references: MutableList<SchemaReference> = mutableListOf()
    val localReferences: MutableList<LocalReference> = mutableListOf()

    fun addReference(name: String, subject: String, version: Int): Subject {
        references.add(SchemaReference(name, subject, version))
        return this
    }

    fun addReference(name: String, subject:String): Subject {
        references.add(SchemaReference(name, subject, -1))
        return this
    }

    fun addLocalReference(name: String, path: String): Subject {
        localReferences.add(LocalReference(name, path))
        return this
    }

    // Used for data class destructuring
    operator fun component4() = references
    operator fun component5() = localReferences
}