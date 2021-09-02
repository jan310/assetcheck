package com.ondra.assetcheck

import org.springframework.stereotype.Service

@Service
class AssetService(private val stockRepository: StockRepository) {

    val characterLimit = 500

    fun saveNewStock(newStock: Stock) : Boolean {
        return if (stockRepository.existsStockByIsin(newStock.isin)) false
        else {
            stockRepository.save(newStock)
            true
        }
    }

    fun saveNewPoint(isin: String, newPoint: Point) : Boolean {
        return if (newPoint.text.length > characterLimit || !stockRepository.existsStockByIsin(isin)) false
        else {
            val stock = stockRepository.findStockByIsin(isin)
            stock.points.add(newPoint)
            stockRepository.save(stock)
            true
        }
    }

}