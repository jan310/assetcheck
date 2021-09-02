package com.ondra.assetcheck

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "stocks")
data class Stock(
    @Id
    val id: String?,
    val isin: String,
    val companyName: String,
    val points: MutableList<Point>, //  list of pros and cons
    val review: String? // optional final statement, maybe a buy/sell recommendation
)
