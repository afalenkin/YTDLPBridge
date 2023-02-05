package com.afalenkin.ytdlpbridge.service.cmd.model

abstract class LineCommand {
    abstract fun getCommand(): List<String>
}
