package com.afalenkin.ytdlpbridge.service.download.impl

import com.afalenkin.ytdlpbridge.duplicatedTestResult
import com.afalenkin.ytdlpbridge.service.cmd.impl.CommandLineExecutorImpl
import com.afalenkin.ytdlpbridge.service.cmdbuilder.CommandBuilder
import com.afalenkin.ytdlpbridge.service.cmdbuilder.YtDlpCommandBuilder
import com.afalenkin.ytdlpbridge.successTestResult
import com.afalenkin.ytdlpbridge.testCommand
import com.afalenkin.ytdlpbridge.testPathVal
import com.ninjasquad.springmockk.MockkBean
import io.kotest.common.runBlocking
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.nio.file.Path

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@SpringBootTest
internal class YtDownloadServiceTest() {
    @MockkBean
    private lateinit var executor: CommandLineExecutorImpl

    @Autowired
    private lateinit var ytDownloadService: YtDownloadService

    //    it can be replaced with @ExtendWith(MockKExtension::class).
    @BeforeEach
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `downloading test`() {
        runBlocking {
            coEvery { executor.execute(any(), any()) } returns successTestResult
            val actual = ytDownloadService.download(testCommand)
            val expected = Path.of(testPathVal).toAbsolutePath()
            assertEquals(expected, actual)
            println(actual)
        }
    }

    @Test
    fun `already downloaded test`() {
        runBlocking {
            coEvery { executor.execute(any(), any()) } returns duplicatedTestResult
            val actual = ytDownloadService.download(testCommand)
            val expected = Path.of(testPathVal).toAbsolutePath()
            assertEquals(expected, actual)
            println(actual)
        }
    }
}