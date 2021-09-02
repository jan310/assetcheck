package com.ondra.assetcheck

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StockRepository : MongoRepository<Stock,String> {

    fun existsStockByIsin(isin: String) : Boolean

    fun findStockByIsin(isin: String): Stock

}