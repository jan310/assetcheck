package com.ondra.assetcheck

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AssetController(private val assetService: AssetService) {

    @PostMapping("postNewStock")
    fun addStock(@RequestBody newStock: Stock): ResponseEntity<Void> {
        return if (assetService.saveNewStock(newStock)) ResponseEntity.status(HttpStatus.CREATED).build()
        else ResponseEntity.status(HttpStatus.CONFLICT).build()
    }

    @PostMapping("postNewPoint/{stockId}")
    fun addPoint(@PathVariable stockId: String, @RequestBody newPoint: Point): ResponseEntity<Void> {
        return if (assetService.saveNewPoint(stockId, newPoint)) ResponseEntity.status(HttpStatus.CREATED).build()
        else ResponseEntity.status(HttpStatus.CONFLICT).build()
    }

    @GetMapping("getAllStocks")
    fun getAllStocks(): ResponseEntity<List<Stock>> = ResponseEntity.status(HttpStatus.OK).body(assetService.getAllStocks())

    @GetMapping("getStock/{id}")
    fun getStock(@PathVariable id: String): ResponseEntity<Stock> {
        val stock = assetService.getStock(id)
        return if (stock != null) ResponseEntity.status(HttpStatus.OK).body(stock)
        else ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

    @PatchMapping("updateCompanyName/{id}")
    fun updateCompanyName(@PathVariable id: String, @RequestBody companyName: CompanyName): ResponseEntity<Void> {
        return if (assetService.updateCompanyName(id, companyName.companyName)) ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        else ResponseEntity.status(HttpStatus.CONFLICT).build()
    }
    data class CompanyName (val companyName: String)

    @PatchMapping("updateCompanyReview/{id}")
    fun updateCompanyReview(@PathVariable id: String, @RequestBody companyReview: CompanyReview): ResponseEntity<Void> {
        return if (assetService.updateCompanyReview(id, companyReview.companyReview)) ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        else ResponseEntity.status(HttpStatus.CONFLICT).build()
    }
    data class CompanyReview (val companyReview: String)

    @PatchMapping("updatePoint/{stockId}")
    fun updatePoint(@PathVariable stockId: String, @RequestBody point: Point): ResponseEntity<Void> {
        return if (assetService.updatePoint(stockId, point)) ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        else ResponseEntity.status(HttpStatus.CONFLICT).build()
    }

    // deleteStock
    // deletePoint

}