package com.ondra.assetcheck

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AssetController(private val assetService: AssetService) {

    @PostMapping("postNewStock")
    fun addStock(@RequestBody newStock: Stock) : ResponseEntity<Void> {
        return if (assetService.saveNewStock(newStock)) ResponseEntity.status(HttpStatus.CREATED).build()
        else ResponseEntity.status(HttpStatus.CONFLICT).build()
    }

    @PostMapping("postNewPoint/{isin}")
    fun addPoint(@PathVariable isin: String, @RequestBody newPoint: Point) : ResponseEntity<Void> {
        return if (assetService.saveNewPoint(isin, newPoint)) ResponseEntity.status(HttpStatus.CREATED).build()
        else ResponseEntity.status(HttpStatus.CONFLICT).build()
    }

}