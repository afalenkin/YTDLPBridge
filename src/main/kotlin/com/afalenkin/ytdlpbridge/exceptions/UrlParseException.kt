package com.afalenkin.ytdlpbridge.exceptions

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
class UrlParseException : RuntimeException {
    constructor(msg: String, ex: Exception) : super(msg, ex)
    constructor(msg: String) : super(msg)
}