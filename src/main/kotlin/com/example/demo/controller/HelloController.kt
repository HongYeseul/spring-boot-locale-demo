package com.example.demo.controller

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Locale

@RestController
class HelloController(
    private val messageSource: MessageSource
) {
    @GetMapping("/hello")
    fun hello(locale: Locale): String {
        val locale = LocaleContextHolder.getLocale()
        val text = messageSource.getMessage("hello", null, locale)
        return text
    }

}
