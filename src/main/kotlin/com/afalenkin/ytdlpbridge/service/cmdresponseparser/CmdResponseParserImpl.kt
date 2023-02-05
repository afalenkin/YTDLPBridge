package com.afalenkin.ytdlpbridge.service.cmdresponseparser

import com.afalenkin.ytdlpbridge.EMPTY
import com.afalenkin.ytdlpbridge.exceptions.CmdResponseParseException
import org.springframework.stereotype.Service

private const val PAIR_DELIMITER = ":"

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Service
class CmdResponseParserImpl : CmdResponseParser {
    override fun extractResponseValue(responseKey: String, response: String) =
        response.split("\n")
            .filter { it.contains(responseKey) }
            .map { it.replace(responseKey, EMPTY) }
            .map { it.trim() }
            .firstOrNull()
            ?: throw CmdResponseParseException("Fail during extraction $responseKey from \n$response")
}