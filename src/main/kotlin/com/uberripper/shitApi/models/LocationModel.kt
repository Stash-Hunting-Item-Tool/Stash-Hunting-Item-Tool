package com.uberripper.shitApi.models

import com.uberripper.shitApi.objects.Location
import com.uberripper.shitApi.repositories.ItemRepo
import org.springframework.stereotype.Component
import java.util.ArrayList

@Component
class LocationModel(private val itemRepo: ItemRepo) {

    fun findAllLocations(): List<Location> {
        val items = itemRepo.findAll()
        val locations = ArrayList<Location>()
        for(item in items){
            if(!locations.contains(item.location)){
                item.location?.let { locations.add(it) }
            }
        }
        return locations
    }
}