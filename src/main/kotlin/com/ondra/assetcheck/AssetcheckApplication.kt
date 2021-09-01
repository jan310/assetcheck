package com.ondra.assetcheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AssetcheckApplication

fun main(args: Array<String>) {
	runApplication<AssetcheckApplication>(*args)
}
