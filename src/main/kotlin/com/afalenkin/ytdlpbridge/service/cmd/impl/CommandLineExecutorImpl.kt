package com.afalenkin.ytdlpbridge.service.cmd.impl

import com.afalenkin.ytdlpbridge.service.cmd.CommandLineExecutor
import com.afalenkin.ytdlpbridge.service.cmd.ExecutablePathProvider
import com.afalenkin.ytdlpbridge.service.cmd.model.CommandResult
import com.afalenkin.ytdlpbridge.service.cmd.model.LineCommand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runInterruptible
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets.UTF_8
import java.nio.file.Path

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Service
class CommandLineExecutorImpl : CommandLineExecutor {
    override suspend fun execute(executable: ExecutablePathProvider, command: LineCommand): CommandResult =
        executeCommand(executable.path, command.getCommand())

    private suspend fun executeCommand(path: Path, command: List<String>): CommandResult =
        withContext(Dispatchers.IO) {
            val executableCommand = listOf(path.toAbsolutePath().toString()) + command
            val procedure = Runtime.getRuntime().exec(executableCommand.toTypedArray())
            try {

                val stdout = async {
                    runInterruptible {
                        String(procedure.inputStream.readAllBytes(), UTF_8)
                    }
                }

                val stderr = async {
                    runInterruptible {
                        String(procedure.errorStream.readAllBytes(), UTF_8)
                    }
                }

                val exitCode = runInterruptible { procedure.waitFor() }

                CommandResult(exitCode = exitCode, stdout = stdout.await(), stderr = stderr.await())

            } finally {
                procedure.destroy()
            }
        }
}