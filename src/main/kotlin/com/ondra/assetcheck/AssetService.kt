package com.ondra.assetcheck

import org.springframework.stereotype.Service

@Service
class AssetService(private val stockRepository: StockRepository) {

    fun saveNewStock(newStock: Stock) : Boolean {
        return if (stockRepository.existsStockByIsin(newStock.isin)) false
        else {
            stockRepository.save(newStock)
            true
        }
    }

}