package com.example.demo.db.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, length = 255)
    var productCode: String,             // 비즈니스용 코드

    @Column(nullable = false, length = 255)
    var defaultTitle: String = "",

    @Column(columnDefinition = "TEXT")
    var defaultDescription: String? = null,
) {
    // JPA용 기본 생성자
    constructor() : this(null, "", "", null)

}
