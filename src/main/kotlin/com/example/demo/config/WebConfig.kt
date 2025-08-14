package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.nio.charset.StandardCharsets

/**
 * Spring MVC 웹 설정
 */
@Configuration
class WebConfig : WebMvcConfigurer {

    /**
     * UTF-8 인코딩을 사용하는 문자열 HTTP 메시지 컨버터
     */
    @Bean
    fun stringHttpMessageConverter() =
        StringHttpMessageConverter(StandardCharsets.UTF_8)
}
