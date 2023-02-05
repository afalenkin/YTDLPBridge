package com.afalenkin.ytdlpbridge.service.cmd

import com.afalenkin.ytdlpbridge.service.cmd.model.CommandResult
import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
interface CommandLineExecutor {

    suspend fun execute(executable: ExecutablePathProvider, command: LineCommand): CommandResult
}