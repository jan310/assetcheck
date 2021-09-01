package com.ondra.assetcheck

import java.util.UUID

data class Pro(
    val id: String = UUID.randomUUID().toString(),
    val priority: Int,
    val text: String
)
