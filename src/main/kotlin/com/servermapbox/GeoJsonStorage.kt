package com.servermapbox

import com.servermapbox.dto.GeoJsonObject

object GeoJsonStorage {
    private val geoJsonObjects = mutableMapOf<String, GeoJsonObject>()
    private var lastUsedId: Int = -1 // Start with -1 to get the first ID as 0

    fun addGeoJsonObject(geoJsonObject: GeoJsonObject) {
        val id = getNextId()
        geoJsonObjects[id] = geoJsonObject.copy(id = id)
    }

    private fun getNextId(): String {
        lastUsedId++
        return lastUsedId.toString()
    }

    fun addGeoJsonObject(id: String, geoJsonObject: GeoJsonObject) {
        geoJsonObjects[id] = geoJsonObject
    }

    fun getGeoJsonObject(id: String): GeoJsonObject? {
        return geoJsonObjects[id]
    }

    fun getAllGeoJsonObjects(): List<GeoJsonObject> {
        return geoJsonObjects.values.toList()
    }

    fun updateGeoJsonObject(id: String, updatedObject: GeoJsonObject) {
        geoJsonObjects[id] = updatedObject
    }

}