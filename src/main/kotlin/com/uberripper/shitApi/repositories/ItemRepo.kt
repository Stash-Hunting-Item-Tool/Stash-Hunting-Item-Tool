package com.uberripper.shitApi.repositories

import com.uberripper.shitApi.objects.Items
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository


interface ItemRepo : MongoRepository<Items, String> {
    fun findOneById(id: ObjectId): Items
    override fun deleteAll()

}
