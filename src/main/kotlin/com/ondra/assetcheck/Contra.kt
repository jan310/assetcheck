package com.ondra.assetcheck

import java.util.*

data class Contra(
    val id: String = UUID.randomUUID().toString(),
    val text: String
)
