package com.example.demo.db.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(
    name = "product_localization",
    uniqueConstraints = [UniqueConstraint(columnNames = ["product_id", "locale"])]
)
class ProductLocalization(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var product: Product? = null,

    @Column(nullable = false, length = 10)
    var locale: String,    // "en", "ko", "ja", "en-US" 등

    @Column(nullable = false, length = 255)
    var title: String,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,
) {
    // JPA용 기본 생성자
    constructor() : this(null, null, "", "", null)
}
