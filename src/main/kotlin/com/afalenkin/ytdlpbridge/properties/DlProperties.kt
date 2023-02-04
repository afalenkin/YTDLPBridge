package com.afalenkin.ytdlpbridge.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@ConfigurationProperties(prefix = "yt.dlp")
@ConfigurationPropertiesScan
class DlProperties(
    val dlpPath: String,
    val locationFlag: String,
    val location: String,
    val converterFlag: String,
    val converterLocation: String,
    val extractFlag: String,
    val formatFlag: String,
)