package com.afalenkin.ytdlpbridge

import com.afalenkin.ytdlpbridge.properties.DlProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(value = [DlProperties::class])
class YtdlpBridgeApplication

fun main(args: Array<String>) {
    runApplication<YtdlpBridgeApplication>(*args)
}
