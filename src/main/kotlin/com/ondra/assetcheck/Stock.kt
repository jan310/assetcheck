package com.ondra.assetcheck

data class Stock(
    val id: String?,
    val isin: String,
    val name: String,
    val pros: List<Pro>,
    val cons: List<Contra>,
)
