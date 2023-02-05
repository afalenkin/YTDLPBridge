package com.afalenkin.ytdlpbridge.service.linkparser

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
interface LinkParser {
    fun extractQueryParam(link: String, param: String): String
}