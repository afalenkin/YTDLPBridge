package com.afalenkin.ytdlpbridge.commandline.impl

import com.afalenkin.ytdlpbridge.service.cmd.CommandLineExecutor
import com.afalenkin.ytdlpbridge.service.cmd.ExecutablePathProvider
import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand
import com.afalenkin.ytdlpbridge.model.DownloadFormat
import com.afalenkin.ytdlpbridge.model.command.YtDlpCommand
import com.afalenkin.ytdlpbridge.testCommand
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
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
    @Disabled
    fun `only for dev!`() {

        val result = runBlocking {
            cmdExecutor.execute(ytDlpPath, testCommand)
        }
        print(result)
        assertEquals(0, result.exitCode)
        assertTrue(result.stdout.isNotEmpty())
        assertTrue(result.stderr.isEmpty())
    }
}