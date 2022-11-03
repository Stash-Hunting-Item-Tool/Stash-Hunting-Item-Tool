package com.uberripper.shitApi.controller;

import com.uberripper.shitApi.models.ItemModel
import com.uberripper.shitApi.objects.Items
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ItemController(private val itemModel: ItemModel) {

    @GetMapping("/")
    fun index(): String {
        return "I'm alive"
    }

    @GetMapping("/getAll")
    fun getAll(): ResponseEntity<List<Items>> {
        val items = itemModel.findAllItems()
        return ResponseEntity.ok(items)
    }

    @GetMapping("/getAllAtLocation")
    fun getAllAtLocation(@RequestParam(name = "address") address: String): ResponseEntity<List<Items>> {
        val items = itemModel.findAllByLocationLocAddress(address)
        return ResponseEntity.ok(items)
    }

    @GetMapping("/getAllWithName")
    fun getAllWithName(@RequestParam(name = "name") name: String): ResponseEntity<List<Items>> {
        val items = itemModel.findAllByName(name)
        return ResponseEntity.ok(items)
    }

    @GetMapping("/getAllAtLocationWithName")
    fun getAllAtLocationWithName(
        @RequestParam(name = "address") address: String,
        @RequestParam(name = "name") name: String
    ): ResponseEntity<List<Items>> {
        val items = itemModel.findAllByLocationLocAddressAndName(address, name)
        return ResponseEntity.ok(items)
    }

    @PostMapping("/addItem")
    fun addItem(@RequestBody item: Items): ResponseEntity<Items> {
        val item = itemModel.addItem(item)
        return ResponseEntity(item, HttpStatus.CREATED)
    }

    @PostMapping("/deleteItem")
    fun deleteItem(@RequestParam(name = "id") id: String): ResponseEntity<Unit> {
        itemModel.deleteItem(id)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/updateItem")
    fun updateItem(
        @RequestParam(name = "id") id: String,
        @RequestBody item: Items
    ): ResponseEntity<Items> {
        val newItem = itemModel.updateItem(id, item)
        return ResponseEntity.ok(newItem)

    }
}
