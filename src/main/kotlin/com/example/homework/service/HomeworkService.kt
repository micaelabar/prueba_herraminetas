package com.example.homework.service

import com.example.homework.dto.HomeworkDto
import org.springframework.stereotype.Service

@Service
class HomeworkService {

    fun saveHomework(homeworkDto: HomeworkDto): HomeworkDto {
        // Aquí implementas la lógica para guardar la tarea.
        // Por ahora, retornamos el mismo DTO como simulación.
        println("Guardando tarea: ${homeworkDto}")
        return homeworkDto
    }
}
