package com.uberripper.shitApi.repositories

import com.uberripper.shitApi.objects.Items
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query


interface ItemRepo : MongoRepository<Items, String> {
    fun findOneById(id: ObjectId): Items

    fun findAllByName(name: String): List<Items>

    @Query("{'location.locAddress' : '?0'}")
    fun findAllByLocationLocAddress(address: String): List<Items>

    override fun deleteAll()
}
