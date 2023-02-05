package com.afalenkin.ytdlpbridge.config

import com.afalenkin.ytdlpbridge.service.cmd.ExecutablePathProvider
import jakarta.validation.constraints.NotBlank
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import java.nio.file.Path

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Configuration
@PropertySource(value = ["classpath:application.yml"])
class ApplicationConfig {

    @Bean
//    environment.YT_DLP_PATH
    fun ytDlpPath(@Value("\${yt.dlp.dlpPath}") @NotBlank ytDlpPath: String) =
        object : ExecutablePathProvider {
            override val path: Path
                get() = Path.of(ytDlpPath)
        }

}