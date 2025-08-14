package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.nio.charset.StandardCharsets

@Configuration
class WebConfig : WebMvcConfigurer {
    @Bean
    fun stringHttpMessageConverter() =
        StringHttpMessageConverter(StandardCharsets.UTF_8)
}
