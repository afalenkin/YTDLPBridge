package com.afalenkin.ytdlpbridge

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */

fun getLogger(forClass: Class<*>): Logger =
    LoggerFactory.getLogger(forClass)