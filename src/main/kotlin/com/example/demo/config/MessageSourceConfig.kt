package com.example.demo.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource

/**
 * 다국어 메시지 설정
 * properties 파일 기반의 메시지 소스를 구성합니다.
 */
@Configuration
class MessageSourceConfig {

    /**
     * messages.properties 파일을 읽는 메시지 소스
     * - 파일 위치: classpath:messages_*.properties
     * - 개발 시 1초마다 파일 변경사항 reload
     */
    @Bean
    fun messageSource(): MessageSource =
        ReloadableResourceBundleMessageSource().apply {
            setBasenames("classpath:messages")
            setDefaultEncoding("UTF-8")
            setCacheSeconds(1)
        }
}
