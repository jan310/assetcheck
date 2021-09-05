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

    fun saveNewPoint(stockId: String, newPoint: Point): Boolean {
        return if (newPoint.text.length > characterLimit || !(1 .. 3).contains(newPoint.priority) || !stockRepository.existsStockById(stockId)) false
        else {
            val stock = stockRepository.findStockById(stockId).copy(updated = LocalDateTime.now())
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

    fun updatePoint(stockId: String, point: Point): Boolean {
        if (point.text.length > characterLimit ||
            !(1 .. 3).contains(point.priority) ||
            !stockRepository.existsStockById(stockId))
            return false

        val stock = stockRepository.findStockById(stockId).copy(updated = LocalDateTime.now())
        for (i in stock.points.indices) {
            if (stock.points[i].id == point.id) {
                stock.points[i] = point
                stockRepository.save(stock)
                return true
            }
        }

        return false
    }

    fun deleteStock(stockId: String): Boolean {
        return if (!stockRepository.existsStockById(stockId)) false
        else {
            stockRepository.deleteById(stockId)
            true
        }
    }

    fun deletePoint(stockId: String, pointId: String): Boolean {
        if (!stockRepository.existsStockById(stockId)) return false

        val stock = stockRepository.findStockById(stockId).copy(updated = LocalDateTime.now())
        for (i in stock.points.indices) {
            if (stock.points[i].id == pointId) {
                stock.points.removeAt(i)
                stockRepository.save(stock)
                return true
            }
        }

        return false
    }

}