package com.uberripper.shitApi.models

import com.uberripper.shitApi.objects.Items
import com.uberripper.shitApi.repositories.ItemRepo
import org.springframework.stereotype.Component

/**
 * the reason behind this class is to keep no logic in controller.
 */
@Component
class ItemModel (private val itemRepo: ItemRepo){
    fun findAllItems() : List<Items>{
        return itemRepo.findAll()
    }
}