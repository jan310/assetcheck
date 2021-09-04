package com.ondra.assetcheck

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AssetService(private val stockRepository: StockRepository) {

    val characterLimit = 500
    val characterLimitCompanyName = 50

    fun saveNewStock(newStock: Stock): Boolean {
        return if ((newStock.review != null && newStock.review.length > characterLimit) || stockRepository.existsStockById(newStock.id)) false
        else {
            stockRepository.save(newStock)
            true
        }
    }

    fun saveNewPoint(id: String, newPoint: Point): Boolean {
        return if (newPoint.text.length > characterLimit || !stockRepository.existsStockById(id)) false
        else {
            val stock = stockRepository.findStockById(id).copy(updated = LocalDateTime.now())
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

    fun updateCompanyName(id: String, companyName: String): Boolean {
        return if (companyName.length > characterLimitCompanyName || !stockRepository.existsStockById(id)) false
        else {
            stockRepository.save(stockRepository.findStockById(id).copy(companyName = companyName, updated = LocalDateTime.now()))
            true
        }
    }

    fun updateCompanyReview(id: String, companyReview: String): Boolean {
        return if (companyReview.length > characterLimit || !stockRepository.existsStockById(id)) false
        else {
            stockRepository.save(stockRepository.findStockById(id).copy(review = companyReview, updated = LocalDateTime.now()))
            true
        }
    }

}