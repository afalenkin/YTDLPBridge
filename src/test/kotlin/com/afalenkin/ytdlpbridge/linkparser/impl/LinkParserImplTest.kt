package com.afalenkin.ytdlpbridge.linkparser.impl

import com.afalenkin.ytdlpbridge.exceptions.UrlParseException
import com.afalenkin.ytdlpbridge.linkparser.LinkParser
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

private const val link = "https://www.youtube.com/watch?v=_u-7rWKnVVo&ab_channel=Metallica"
private const val paramKey = "v"
private const val expectedParamValue = "_u-7rWKnVVo"

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@SpringBootTest
internal class LinkParserImplTest {
    @Autowired
    private lateinit var parser: LinkParser

    @Test
    fun `extract query param - success`() {
        val actual = parser.extractQueryParam(link = link, param = paramKey)
        assertEquals(expectedParamValue, actual)
    }

    @Test
    fun `extract query param failed if param is absent`() {
        shouldThrow<UrlParseException> {
            parser.extractQueryParam(link = link, param = "dummy")
        }
    }
}