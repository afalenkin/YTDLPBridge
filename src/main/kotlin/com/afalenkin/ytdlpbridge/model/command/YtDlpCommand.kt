package com.afalenkin.ytdlpbridge.model.command

import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
data class YtDlpCommand(
    val locationFlag: String,
    val location: String,
    val converterFlag: String,
    val converterLocation: String,
    val extractFlag: String,
    val formatFlag: String,
    val format: String,
    val contentId: String,
) : LineCommand() {
    //    D:\dlp\yt-dlp --ffmpeg-location D:\dlp\ffmpeg\bin\ffmpeg.exe kXYiU_JCYtU -x --audio-format mp3
    override fun getCommand() =
        listOf(locationFlag, location, converterFlag, converterLocation, extractFlag, formatFlag, format, contentId)
}

