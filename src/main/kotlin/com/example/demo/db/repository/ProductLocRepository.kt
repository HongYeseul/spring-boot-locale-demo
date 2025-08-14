package com.example.demo.db.repository

import com.example.demo.db.entity.ProductLocalization
import org.springframework.data.jpa.repository.JpaRepository


interface ProductLocRepository : JpaRepository<ProductLocalization, Long> {
    // 요청 로케일과 제품 ID로 1건
    fun findFirstByProduct_IdAndLocale(productId: Long, locale: String): ProductLocalization?
}
