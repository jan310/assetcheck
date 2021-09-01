package com.ondra.assetcheck

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AssetController(private val assetService: AssetService) {

    @PostMapping("postNewStock")
    fun addStock(@RequestBody newStock: Stock) = assetService.saveNewStock(newStock)

}