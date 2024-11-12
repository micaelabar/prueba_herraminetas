package com.example.homework.exception

import com.example.homework.response.JSendResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(ex: ConstraintViolationException): ResponseEntity<JSendResponse> {
        val message = ex.message ?: "Error de validación"
        val response = JSendResponse(
            status = "fail",
            message = message
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BindException::class)
    fun handleBindException(ex: BindException): ResponseEntity<JSendResponse> {
        val message = ex.allErrors.joinToString(", ") { it.defaultMessage ?: "Error desconocido" }
        val response = JSendResponse(
            status = "fail",
            message = message
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }
}