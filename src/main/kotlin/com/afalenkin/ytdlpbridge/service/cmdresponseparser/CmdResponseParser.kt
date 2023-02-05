package com.afalenkin.ytdlpbridge.service.cmdresponseparser

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
interface CmdResponseParser {
    fun extractResponseValue(responseKey: String, response: String): String
}