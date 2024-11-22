package com.example.homework.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Homework(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // ID puede ser opcional para entidades JPA

    val nombreTarea: String,
    val descripcion: String,
    val fechaEntrega: String,
    val estado: String
)
