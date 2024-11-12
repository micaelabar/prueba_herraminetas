package com.example.homework.response

data class JSendResponse(
    val status: String,
    val message: String,
    val data: Any? = null
)