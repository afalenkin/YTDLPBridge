package com.afalenkin.ytdlpbridge.service.cmd.model

data class CommandResult(
    val exitCode: Int,
    val stdout: String,
    val stderr: String,
)
