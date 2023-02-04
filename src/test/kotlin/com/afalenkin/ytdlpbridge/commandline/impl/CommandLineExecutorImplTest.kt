package com.afalenkin.ytdlpbridge.commandline.impl

import com.afalenkin.ytdlpbridge.commandline.CommandLineExecutor
import com.afalenkin.ytdlpbridge.commandline.ExecutablePath
import com.afalenkin.ytdlpbridge.commandline.model.LineCommand
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import java.nio.file.Path

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@SpringBootTest
@DirtiesContext()
internal class CommandLineExecutorImplTest {
    @Autowired
    lateinit var cmdExecutor: CommandLineExecutor

    val path = object : ExecutablePath {
        override fun getPath() = Path.of("D:\\dlp\\yt-dlp")
    }

    val command = object : LineCommand() {
        override fun getCommand() = listOf("--help")
    }

    @Test
    @DisplayName("Execute simple cd command on windows")
    fun `execute simple ls command - success`() {
        val result = runBlocking {
            cmdExecutor.execute(path, command)
        }
        assertEquals(0, result.exitCode)
        assertTrue(result.stdout.isNotEmpty())
        assertTrue(result.stderr.isEmpty())
    }
}