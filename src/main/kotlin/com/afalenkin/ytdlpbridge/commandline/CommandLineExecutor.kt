package com.afalenkin.ytdlpbridge.commandline

import com.afalenkin.ytdlpbridge.commandline.model.CommandResult
import com.afalenkin.ytdlpbridge.commandline.model.LineCommand

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
interface CommandLineExecutor {

    suspend fun execute(executable: ExecutablePathProvider, command: LineCommand): CommandResult
}