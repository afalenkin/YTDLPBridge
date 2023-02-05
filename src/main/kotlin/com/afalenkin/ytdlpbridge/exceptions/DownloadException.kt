package com.afalenkin.ytdlpbridge.exceptions

class DownloadException : RuntimeException {
    constructor(msg: String) : super(msg)
    constructor(msg: String, cause: Exception) : super(msg, cause)
}
