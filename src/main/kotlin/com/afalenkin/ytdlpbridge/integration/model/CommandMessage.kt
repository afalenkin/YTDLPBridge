package com.afalenkin.ytdlpbridge.integration.model

import com.afalenkin.ytdlpbridge.model.ContentSource
import com.afalenkin.ytdlpbridge.model.DownloadFormat

data class CommandMessage(
    val url: String,
    val format: DownloadFormat,
    val source: ContentSource
)
