package com.afalenkin.ytdlpbridge.service.cmdbuilder

import com.afalenkin.ytdlpbridge.model.DownloadFormat
import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
interface CommandBuilder {
    fun build(formatCode: String = DownloadFormat.MP3.formatCode, contentId: String): LineCommand
}