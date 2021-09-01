package com.ondra.assetcheck

import java.util.UUID

data class Contra(
    val id: String = UUID.randomUUID().toString(),
    val priority: Int,
    val text: String
)
