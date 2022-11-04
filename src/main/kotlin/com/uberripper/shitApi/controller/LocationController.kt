package com.uberripper.shitApi.controller

import com.uberripper.shitApi.models.LocationModel
import com.uberripper.shitApi.objects.Location
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationController(private val locationModel: LocationModel) {
    @GetMapping("/getAllLocations")
    fun getAll(): ResponseEntity<List<Location>> {
        val locations = locationModel.findAllLocations()
        return ResponseEntity.ok(locations)
    }
}