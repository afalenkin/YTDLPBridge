package com.afalenkin.ytdlpbridge.commandline.impl

import com.afalenkin.ytdlpbridge.commandline.CommandLineExecutor
import com.afalenkin.ytdlpbridge.commandline.ExecutablePathProvider
import com.afalenkin.ytdlpbridge.commandline.model.LineCommand
import com.afalenkin.ytdlpbridge.model.DownloadFormat
import com.afalenkin.ytdlpbridge.model.command.YtDlpCommand
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@SpringBootTest
@ExtendWith(SpringExtension::class)
internal class CommandLineExecutorImplTest {
    @Autowired
    private lateinit var cmdExecutor: CommandLineExecutor

    @Autowired
    private lateinit var ytDlpPath: ExecutablePathProvider

    val command = object : LineCommand() {
        override fun getCommand() = listOf("--help")
    }

    @Test
    @DisplayName("Execute simple cd command on windows")
    fun `execute simple help command - success`() {
        val result = runBlocking {
            cmdExecutor.execute(ytDlpPath, command)
        }
        assertEquals(0, result.exitCode)
        assertTrue(result.stdout.isNotEmpty())
        assertTrue(result.stderr.isEmpty())
    }

    //    D:\dlp\yt-dlp --ffmpeg-location D:\dlp\ffmpeg\bin\ffmpeg.exe kXYiU_JCYtU -x --audio-format mp3
    @Test
    @DisplayName("Execute simple cd command on windows")
    fun `only for dev!`() {
        val dlpCommandDev = YtDlpCommand(
            locationFlag = "-P",
            location = "downloads",
            converterFlag = "--ffmpeg-location",
            converterLocation = "D:\\dlp\\ffmpeg\\bin\\ffmpeg.exe",
            extractFlag = "-x",
            formatFlag = "--audio-format",
            format = DownloadFormat.MP3.formatCode,
            contentId = "kXYiU_JCYtU",
        )

        val result = runBlocking {
            cmdExecutor.execute(ytDlpPath, dlpCommandDev)
        }
        print(result)
        assertEquals(0, result.exitCode)
        assertTrue(result.stdout.isNotEmpty())
        assertTrue(result.stderr.isEmpty())
    }
}