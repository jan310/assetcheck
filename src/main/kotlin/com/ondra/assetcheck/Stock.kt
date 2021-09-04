package com.ondra.assetcheck

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "stocks")
data class Stock(
    @Id
    val id: String, // ISIN
    val companyName: String,
    val points: MutableList<Point>, //  list of pros and cons
    val review: String?, // final statement, maybe a buy/sell recommendation (optional)
    val created: LocalDateTime = LocalDateTime.now(),
    val updated: LocalDateTime = created
)
