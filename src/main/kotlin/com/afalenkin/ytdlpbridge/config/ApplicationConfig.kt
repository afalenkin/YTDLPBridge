package com.afalenkin.ytdlpbridge.config

import com.afalenkin.ytdlpbridge.commandline.ExecutablePathProvider
import jakarta.validation.constraints.NotBlank
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.nio.file.Path

/**
 *@author Alenkin Andrew
 *oxqq@ya.ru
 */
@Configuration
class ApplicationConfig {

    @Bean
    fun ytDlpPath(@Value("#{environment.YT_DLP_PATH}") @NotBlank ytDlpPath: String) =
        object : ExecutablePathProvider {
            override val path: Path
                get() = Path.of(ytDlpPath)
        }

}