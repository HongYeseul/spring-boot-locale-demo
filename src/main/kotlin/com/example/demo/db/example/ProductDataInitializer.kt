package com.example.demo.db.example

import com.example.demo.db.entity.Product
import com.example.demo.db.entity.ProductLocalization
import com.example.demo.db.repository.ProductLocRepository
import com.example.demo.db.repository.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductDataInitializer {

    @Bean
    fun seed(productRepo: ProductRepository, locRepo: ProductLocRepository) = CommandLineRunner {
        // 기존 데이터가 있는지 확인
        if (productRepo.count() > 0) {
            return@CommandLineRunner
        }

        val p = productRepo.save(Product(sku = "demo-001", defaultTitle = "Demo Product"))

        locRepo.saveAll(
            listOf(
                ProductLocalization(product = p, locale = "en", title = "Demo Product", description = "English desc"),
                ProductLocalization(product = p, locale = "ko", title = "데모 상품", description = "한국어 설명"),
                ProductLocalization(product = p, locale = "ja", title = "デモ商品", description = "日本語説明")
            )
        )
    }
}
