package com.servermapbox.plugins

import com.servermapbox.GeoJsonStorage
import com.servermapbox.dto.GeoJsonObject
import com.servermapbox.dto.GeoJsonObjectDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    routing {
        route("/geojson") {
            post {
                val geoJsonObjectDto = call.receive<GeoJsonObjectDto>()
                val geoJsonObject = GeoJsonObject(
                    "",
                    geoJsonObjectDto.name,
                    geoJsonObjectDto.description,
                    geoJsonObjectDto.latitude,
                    geoJsonObjectDto.longitude
                )
                GeoJsonStorage.addGeoJsonObject(geoJsonObject)
                call.respond(HttpStatusCode.Created, "Object added successfully")
            }

            get {
                call.respond(GeoJsonStorage.getAllGeoJsonObjects())
            }

            get("/{id}") {
                val id = call.parameters["id"]
                val geoJsonObject = GeoJsonStorage.getGeoJsonObject(id.orEmpty())
                if (geoJsonObject != null) {
                    call.respond(geoJsonObject)
                } else {
                    call.respond(HttpStatusCode.NotFound, "Object not found")
                }
            }
        }
    }
}
