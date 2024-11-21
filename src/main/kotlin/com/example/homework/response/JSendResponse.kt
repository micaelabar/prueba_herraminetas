package com.example.homework.response

data class JSendResponse(
    val status: String,
    val message: String,
    val data: Any? = null
) {
    companion object {
        // Método para respuesta exitosa
        fun success(data: Any, message: String): JSendResponse {
            return JSendResponse(status = "success", message = message, data = data)
        }

        // Método para respuesta fallida
        fun fail(data: Any, message: String): JSendResponse {
            return JSendResponse(status = "fail", message = message, data = data)
        }

        // Método para respuesta con error
        fun error(message: String, code: Int): JSendResponse {
            return JSendResponse(status = "error", message = message, data = "Error code: $code")
        }
    }
}
