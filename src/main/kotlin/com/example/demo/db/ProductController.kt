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

/**
 * 상품 관련 REST API 컨트롤러
 */
@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productReadService: ProductReadService,
) {

    /**
     * 상품 단건 조회
     *
     * @param id 상품 ID
     * @param locale Accept-Language 헤더에서 자동 주입되는 언어 설정
     * @return 다국어 처리된 상품 정보
     */
    @GetMapping("/{id}")
    fun getProduct(
        @PathVariable id: Long,
        locale: Locale,
        // @RequestHeader(name = "Accept-Language", defaultValue = "ko")
        // String locale 처럼 @RequestHeader를 사용해서 직접 추출 할 수도 있음
    ): ResponseEntity<ProductDto> {

        val languageCode = locale.language.ifBlank { "en" }
        val dto = productReadService.get(productId = id, locale = languageCode)

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_LANGUAGE, languageCode)
            .body(dto)
    }
}
