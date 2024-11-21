package com.example.homework.controller

import com.example.homework.dto.HomeworkDto
import com.example.homework.response.JSendResponse
import com.example.homework.service.HomeworkService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(
    private val homeworkService: HomeworkService // Inyección de dependencia vía constructor
) {

    @PostMapping("/success")
    fun success(@RequestBody @Valid homeworkDto: HomeworkDto, bindingResult: BindingResult): ResponseEntity<JSendResponse> {
        // Validación de errores en los datos enviados
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                JSendResponse.fail(
                    data = bindingResult.allErrors.map { it.defaultMessage },
                    message = "Errores en la validación de los datos"
                )
            )
        }


        val savedHomework = homeworkService.saveHomework(homeworkDto)

        return ResponseEntity.ok(
            JSendResponse.success(
                data = savedHomework,
                message = "Operación exitosa"
            )
        )
    }

    @PostMapping("/fail")
    fun fail(@RequestBody @Valid homeworkDto: HomeworkDto): ResponseEntity<JSendResponse> {
        // Simulación de un fallo
        return ResponseEntity.status(400).body(
            JSendResponse.fail(
                data = homeworkDto,
                message = "Hubo un problema con la solicitud"
            )
        )
    }

    @PostMapping("/error")
    fun error(): ResponseEntity<JSendResponse> {
        // Simulación de un error del servidor
        return ResponseEntity.status(500).body(
            JSendResponse.error(
                message = "Error en el servidor",
                code = 500
            )
        )
    }
}
