package com.example.demo.db.service

import com.example.demo.db.repository.ProductLocRepository
import com.example.demo.db.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductReadService(
    private val productRepository: ProductRepository,
    private val productLocRepository: ProductLocRepository,
) {
    fun get(productId: Long, locale: String): ProductDto {
        val product = productRepository.findById(productId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "product not found")
        }

        val translatedProduct = productLocRepository.findFirstByProduct_IdAndLocale(productId, locale)

        return if (translatedProduct != null) {
            ProductDto(product.id!!, translatedProduct.title, translatedProduct.description)
        } else {
            // 번역이 한 건도 없으면 기본값 사용
            ProductDto(product.id!!, product.defaultTitle, product.defaultDescription)
        }
    }
}

data class ProductDto(
    val id: Long,
    val title: String,
    val description: String?
)
