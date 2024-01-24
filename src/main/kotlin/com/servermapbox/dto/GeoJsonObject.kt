package com.servermapbox.dto

import kotlinx.serialization.Serializable

@Serializable
data class GeoJsonObject(
    val id: String,
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
)