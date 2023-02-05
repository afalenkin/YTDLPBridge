package com.afalenkin.ytdlpbridge.service.cmdbuilder

import com.afalenkin.ytdlpbridge.model.DownloadFormat
import com.afalenkin.ytdlpbridge.model.command.YtDlpCommand
import com.afalenkin.ytdlpbridge.properties.DlProperties
import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand
import org.springframework.stereotype.Service

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Service
class YtDlpCommandBuilder(val properties: DlProperties) : CommandBuilder {
    override fun build(formatCode: String, contentId: String): LineCommand =
    YtDlpCommand(
        locationFlag = properties.locationFlag,
        location = properties.location,
        converterFlag = properties.converterFlag,
        converterLocation = properties.converterLocation,
        extractFlag = properties.extractFlag,
        formatFlag = properties.formatFlag,
        format = formatCode,
        contentId = contentId,
    )
}