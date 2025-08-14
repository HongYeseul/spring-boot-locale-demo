package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*

@Configuration
class LocaleConfig {

    @Bean
    fun localeResolver(): LocaleResolver {
        val resolver = AcceptHeaderLocaleResolver().apply {
            // 지원하는 언어
            setSupportedLocales(
                listOf(
                    Locale.ENGLISH,    // "en"
                    Locale.KOREAN,     // "ko"
                    Locale.JAPANESE,   // "ja"
                    Locale.CHINESE     // "zh"
                )
            )
            // 기본으로 전달할 언어
            setDefaultLocale(Locale.ENGLISH)
        }

        return resolver
    }
}

/*
    실제 프로덕션에서 일어나는 일들:

    1. 봇/크롤러가 이상한 Accept-Language 보냄
        - "Accept-Language: *"
        - "Accept-Language: invalid-locale"
        → 설정 없으면: 예측 불가능한 동작
        → 설정 있으면: 안전하게 영어로 처리

    2. 새로운 국가 사용자가 접속
        - "Accept-Language: th-TH" (태국어)
        - DB에 태국어 번역 데이터 없음
        → 설정 없으면: "th"로 검색 → 빈 결과 또는 에러
        → 설정 있으면: 자동으로 영어로 폴백

    3. 개발자가 실수로 잘못된 언어코드 사용
        - 클라이언트에서 "Accept-Language: kr" (잘못됨, "ko"가 맞음)
        → 설정 없으면: "kr"로 DB 검색
        → 설정 있으면: supportedLocales에 없으므로 영어로 처리

    4. 서버 환경이 바뀌어도 일관성 유지
        - 로컬 개발: MacOS (영어)
        - 스테이징: Ubuntu (영어)
        - 프로덕션: CentOS (한국어 설정)
        → 설정 없으면: 각 환경마다 다른 기본값
        → 설정 있으면: 모든 환경에서 동일한 영어 기본값
*/
