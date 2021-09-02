package com.ondra.assetcheck

import java.util.UUID

data class Point(
    val id: String = UUID.randomUUID().toString(),
    val positive: Boolean, // true = positive point | false = negative aspect
    val priority: Int, // 3 = high | 2 = medium | 1 = low
    val text: String
)
