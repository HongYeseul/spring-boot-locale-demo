package com.example.demo.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource

/**
 * DB에서 데이터를 가져오는 방법이 아니라면 필요
 */
@Configuration
class MessageSourceConfig {
    @Bean
    fun messageSource(): MessageSource =
        ReloadableResourceBundleMessageSource().apply {
            setBasenames("classpath:messages")
            setDefaultEncoding("UTF-8")
            setCacheSeconds(1)
        }
}
