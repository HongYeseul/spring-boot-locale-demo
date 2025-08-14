package com.example.demo

//@Configuration
//class LocaleConfig : WebMvcConfigurer {
//
//    // Spring Boot 기본도 AcceptHeaderLocaleResolver지만,
//    // 지원 언어와 기본값을 명시적으로 세팅해 둡니다.
//    @Bean
//    fun localeResolver(): LocaleResolver {
//        val resolver = AcceptHeaderLocaleResolver()
//        resolver.setDefaultLocale(Locale.KOREA) // 기본: ko
//        resolver.setSupportedLocales(listOf(Locale.KOREA, Locale.US)) // ko, en
//        return resolver
//    }
//
//    // ✨ 중요: 헤더 기반은 파라미터로 언어를 바꾸지 않으므로
//    // LocaleChangeInterceptor를 등록하지 않습니다.
//}
