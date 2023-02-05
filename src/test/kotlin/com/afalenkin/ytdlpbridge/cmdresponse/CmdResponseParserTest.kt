package com.afalenkin.ytdlpbridge.cmdresponse

import com.afalenkin.ytdlpbridge.exceptions.CmdResponseParseException
import com.afalenkin.ytdlpbridge.model.CmdOutputKeys
import com.afalenkin.ytdlpbridge.service.cmdresponseparser.CmdResponseParser
import com.afalenkin.ytdlpbridge.testPathVal
import com.afalenkin.ytdlpbridge.testResponse
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@SpringBootTest
internal class CmdResponseParserTest {

    @Autowired
    private lateinit var parser: CmdResponseParser

    @Test
    fun `extract destination from response`() {
        val actualResponseVal = parser.extractResponseValue(CmdOutputKeys.AUDIO_LOCATION.value, testResponse)
        assertEquals(testPathVal, actualResponseVal)
    }

    @Test
    fun `fail to extract by absent key`() {
        shouldThrow<CmdResponseParseException> {
            parser.extractResponseValue("dummy", testResponse)
        }
    }
}