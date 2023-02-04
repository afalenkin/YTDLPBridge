package com.afalenkin.ytdlpbridge.linkparser.impl

import com.afalenkin.ytdlpbridge.exceptions.UrlParseException
import com.afalenkin.ytdlpbridge.linkparser.LinkParser
import org.springframework.stereotype.Service
import java.net.URL

private const val QUERY_SPLIT_SYMBOL = "&"

private const val QUERY_PAIR_DELIMITER = "="

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Service
class LinkParserImpl : LinkParser {
    override fun extractQueryParam(link: String, param: String): String {
        return try {
            URL(link).query.split(QUERY_SPLIT_SYMBOL).map {
                val parts = it.split(QUERY_PAIR_DELIMITER)
                val name = parts.firstOrNull() ?: ""
                val value = parts.drop(1).firstOrNull() ?: ""
                name to value
            }.firstOrNull { it.first == param }?.second
                ?: throw IllegalArgumentException("Query $link does not contains parameter $param")
        } catch (e: Exception) {
            throw UrlParseException("Failed to parse $link", e)
        }
    }
}