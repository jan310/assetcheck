package com.ondra.assetcheck

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "stocks")
data class Stock(
    @Id
    val id: String?,
    val isin: String,
    val name: String,
    val pros: List<Pro>,
    val cons: List<Contra>,
    val review: String?
)
