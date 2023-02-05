package com.afalenkin.ytdlpbridge.service.download

import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand
import java.nio.file.Path

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
interface DownloadService {
    suspend fun download(command: LineCommand): Path
}