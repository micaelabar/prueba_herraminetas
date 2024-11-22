package com.example.homework.controller

import com.example.homework.dto.HomeworkDto
import com.example.homework.service.HomeworkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/homework")
class HomeworkController {

    @Autowired
    lateinit var homeworkService: HomeworkService

    @PostMapping("/save")
    fun save(@RequestBody homeworkDto: HomeworkDto): ResponseEntity<Any> {
        val savedHomework = homeworkService.saveHomework(homeworkDto) // Aquí llama a saveHomework
        return ResponseEntity.ok(
            mapOf(
                "status" to "success",
                "data" to savedHomework,
                "message" to "Tarea guardada exitosamente"
            )
        )
    }
}
