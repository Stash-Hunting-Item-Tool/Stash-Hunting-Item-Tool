package com.uberripper.shitApi.models

import com.uberripper.shitApi.objects.Items
import com.uberripper.shitApi.repositories.ItemRepo
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

/**
 * the reason behind this class is to keep no logic in controller.
 */
@Component
class ItemModel(private val itemRepo: ItemRepo) {

    fun findAllItems(): List<Items> {

        return itemRepo.findAll()
    }

    fun addItem(item: Items): Items {

        return itemRepo.save(item)
    }

    fun updateItem(
        id: String,
        newItem: Items
    ): Items {

        val item = itemRepo.findOneById(ObjectId(id))
        newItem.id = item.id

        return itemRepo.save(newItem)
    }

    fun deleteItem(id: String) {

        return itemRepo.deleteById(id)
    }

    fun findAllByName(name: String): List<Items> {

        return itemRepo.findAllByName(name)
    }

    fun findAllByLocationLocAddress(locAddress: String): List<Items> {

        return itemRepo.findAllByLocationLocAddress(locAddress)
    }

    fun findAllByLocationLocAddressAndName(locAddress: String, name: String): List<Items> {

        return itemRepo.findAllByLocationLocAddressAndName(locAddress, name)
    }

    fun findById(id: String): Items? {
        if(itemRepo.existsById(id)) {
            return itemRepo.findOneById(ObjectId(id))
        }
        return null
    }
}