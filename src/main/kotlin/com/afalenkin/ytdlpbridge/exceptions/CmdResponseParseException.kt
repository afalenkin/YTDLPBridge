package com.afalenkin.ytdlpbridge.exceptions

class CmdResponseParseException : RuntimeException {
    constructor(msg: String) : super(msg)
    constructor(msg: String, cause: Exception) : super(msg, cause)
}
