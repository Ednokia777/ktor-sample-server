package com.servermapbox.dto

import kotlinx.serialization.Serializable

@Serializable
data class GeoJsonObjectDto(
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
)