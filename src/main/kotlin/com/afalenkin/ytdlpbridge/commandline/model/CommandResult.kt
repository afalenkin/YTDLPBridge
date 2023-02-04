package com.afalenkin.ytdlpbridge.commandline.model

data class CommandResult(
    val exitCode: Int,
    val stdout: String,
    val stderr: String,
)
