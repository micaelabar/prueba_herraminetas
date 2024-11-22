package com.example.homework.dto

data class HomeworkDto(
    val id: Long? = null, // ID puede ser opcional
    val nombreTarea: String,
    val descripcion: String,
    val fechaEntrega: String,
    val estado: String
)
