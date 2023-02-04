package com.afalenkin.ytdlpbridge.commandline.model

abstract class LineCommand {
    abstract fun getCommand(): List<String>
}
