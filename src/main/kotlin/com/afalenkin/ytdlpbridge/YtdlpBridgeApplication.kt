package com.afalenkin.ytdlpbridge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YtdlpBridgeApplication

fun main(args: Array<String>) {
    runApplication<YtdlpBridgeApplication>(*args)
}
