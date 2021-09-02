package com.ondra.assetcheck

import org.springframework.stereotype.Service

@Service
class AssetService(private val stockRepository: StockRepository) {

    val characterLimit = 500

    fun saveNewStock(newStock: Stock): Boolean {
        return if (stockRepository.existsStockById(newStock.id)) false
        else {
            stockRepository.save(newStock)
            true
        }
    }

    fun saveNewPoint(id: String, newPoint: Point): Boolean {
        return if (newPoint.text.length > characterLimit || !stockRepository.existsStockById(id)) false
        else {
            val stock = stockRepository.findStockById(id)
            stock.points.add(newPoint)
            stockRepository.save(stock)
            true
        }
    }

    fun getAllStocks(): List<Stock> = stockRepository.findAll()

    fun getStock(id: String): Stock? {
        return if (!stockRepository.existsStockById(id)) null
        else stockRepository.findStockById(id)
    }

}