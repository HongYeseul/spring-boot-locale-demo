package com.example.demo.db.repository

import com.example.demo.db.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
}
