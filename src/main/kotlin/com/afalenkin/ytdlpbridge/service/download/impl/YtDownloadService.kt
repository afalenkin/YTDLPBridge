package com.afalenkin.ytdlpbridge.service.download.impl

import com.afalenkin.ytdlpbridge.HAS_ALREADY_BEEN_DOWNLOADED
import com.afalenkin.ytdlpbridge.exceptions.DownloadException
import com.afalenkin.ytdlpbridge.getLogger
import com.afalenkin.ytdlpbridge.model.CmdOutputKeys
import com.afalenkin.ytdlpbridge.service.cmd.CommandLineExecutor
import com.afalenkin.ytdlpbridge.service.cmd.ExecutablePathProvider
import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand
import com.afalenkin.ytdlpbridge.service.cmdresponseparser.CmdResponseParser
import com.afalenkin.ytdlpbridge.service.download.DownloadService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.nio.file.Path


/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Service
class YtDownloadService(
    private val executor: CommandLineExecutor,
    private val parser: CmdResponseParser,
    @Qualifier("ytDlpPath") private val pathProvider: ExecutablePathProvider,
) : DownloadService {

    private val logger = getLogger(YtDownloadService::class.java)

    override suspend fun download(command: LineCommand): Path {
        val result = executor.execute(pathProvider, command)
        if (result.exitCode != 0) {
            throw DownloadException("Unable to execute ${command.getCommand()}, error: ${result.exitCode} - ${result.stderr}")
        }
        val stdout = result.stdout
        val path = if (stdout.contains(HAS_ALREADY_BEEN_DOWNLOADED)) {
            parser.extractResponseValue(CmdOutputKeys.ALREADY_DOWNLOADED.value, stdout)
                .replace(HAS_ALREADY_BEEN_DOWNLOADED, "").trim()
        } else {
            logger.warn("Content ${command.getCommand()} has been already downloaded")
            parser.extractResponseValue(CmdOutputKeys.AUDIO_LOCATION.value, stdout)
        }
        return Path.of(path).toAbsolutePath()
    }
}