package com.afalenkin.ytdlpbridge

import com.afalenkin.ytdlpbridge.model.DownloadFormat
import com.afalenkin.ytdlpbridge.model.command.YtDlpCommand
import com.afalenkin.ytdlpbridge.service.cmd.model.CommandResult

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */

val testPathVal = "downloads\\Numb [Official Music Video] - Linkin Park [kXYiU_JCYtU].mp3"

val testResponse = """CommandResult(exitCode=0, stdout=[youtube] Extracting URL: kXYiU_JCYtU
[youtube] kXYiU_JCYtU: Downloading webpage
[youtube] kXYiU_JCYtU: Downloading android player API JSON
[info] kXYiU_JCYtU: Downloading 1 format(s): 251
[download] Destination: downloads\Numb [Official Music Video] - Linkin Park [kXYiU_JCYtU].webm
[download] 100% of    2.78MiB in 00:00:00 at 4.11MiB/s   
[ExtractAudio] Destination: downloads\Numb [Official Music Video] - Linkin Park [kXYiU_JCYtU].mp3
Deleting original file downloads\Numb [Official Music Video] - Linkin Park [kXYiU_JCYtU].webm (pass -k to keep)"""

val duplicateTestResponse = """[youtube] Extracting URL: kXYiU_JCYtU
[youtube] kXYiU_JCYtU: Downloading webpage
[youtube] kXYiU_JCYtU: Downloading android player API JSON
[info] kXYiU_JCYtU: Downloading 1 format(s): 251
[download] downloads\Numb [Official Music Video] - Linkin Park [kXYiU_JCYtU].mp3 has already been downloaded
[ExtractAudio] Not converting audio downloads\Numb [Official Music Video] - Linkin Park [kXYiU_JCYtU].mp3; file is already in target format mp3"""

val successTestResult = CommandResult(
    exitCode = 0,
    stdout = testResponse, stderr = ""
)

val duplicatedTestResult = CommandResult(
    exitCode = 0,
    stdout = duplicateTestResponse, stderr = ""
)

val testCommand = YtDlpCommand(
    locationFlag = "-P",
    location = "downloads",
    converterFlag = "--ffmpeg-location",
    converterLocation = "D:\\dlp\\ffmpeg\\bin\\ffmpeg.exe",
    extractFlag = "-x",
    formatFlag = "--audio-format",
    format = DownloadFormat.MP3.formatCode,
    contentId = "kXYiU_JCYtU",
)