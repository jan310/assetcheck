package com.ondra.assetcheck

import org.springframework.stereotype.Service

@Service
class AssetService(private val stockRepository: StockRepository) {

    fun saveNewStock(newStock: Stock) = stockRepository.save(newStock)

}