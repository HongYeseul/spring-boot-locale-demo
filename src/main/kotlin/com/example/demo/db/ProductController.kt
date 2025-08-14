package com.example.demo.db

import com.example.demo.db.service.ProductDto
import com.example.demo.db.service.ProductReadService
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productReadService: ProductReadService,
) {

    @GetMapping("/{id}")
    fun getProduct(
        @PathVariable id: Long,
        locale: Locale, // Spring이 자동으로 http 헤더의 locale 설정을 주입해줌
    ): ResponseEntity<ProductDto> {

        val languageCode = locale.language.ifBlank { "en" }
        val dto = productReadService.get(productId = id, locale = languageCode)

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_LANGUAGE, languageCode)
            .body(dto)
    }
}
