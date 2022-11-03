package com.uberripper.shitApi.controller;

import com.uberripper.shitApi.models.ItemModel
import com.uberripper.shitApi.objects.Items
import com.uberripper.shitApi.repositories.ItemRepo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ItemController (private val itemModel: ItemModel) {

    @GetMapping("/")
    fun index(): String {
        return "I'm alive"
    }

    @GetMapping("/getAll")
    fun getAll(): ResponseEntity<List<Items>> {
        val patients = itemModel.findAllItems()
        return ResponseEntity.ok(patients)
    }
}
