package com.example.homework.service

import com.example.homework.dto.HomeworkDto
import com.example.homework.mapper.HomeworkMapper
import com.example.homework.repository.HomeworkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.validation.BindingResult

@Service
class HomeworkService {

    @Autowired
    lateinit var homeworkRepository: HomeworkRepository

    @Autowired
    lateinit var homeworkMapper: HomeworkMapper

    // Método para guardar la tarea
    fun save(homeworkDto: HomeworkDto, bindingResult: BindingResult): ResponseEntity<Any> {
        // Validación de errores en los datos
        if (bindingResult.hasErrors()) {
            // Si hay errores en los datos, se devuelven los mensajes de error
            val errorMessages = bindingResult.allErrors.map { it.defaultMessage }.joinToString(", ")
            return ResponseEntity.badRequest().body(mapOf("status" to "error", "message" to errorMessages))
        }

        // Convertir el DTO a la entidad utilizando el mapper
        val homework = homeworkMapper.toEntity(homeworkDto)

        // Guardar la entidad en la base de datos
        val savedHomework = homeworkRepository.save(homework)

        // Convertir la entidad guardada nuevamente a DTO y devolver la respuesta
        return ResponseEntity.ok(mapOf("status" to "success", "data" to homeworkMapper.toDto(savedHomework)))
    }

    // Método para obtener todas las tareas
    fun getHomework(): ResponseEntity<Any> {
        // Obtener todas las tareas de la base de datos
        val homeworkList = homeworkRepository.findAll().map { homeworkMapper.toDto(it) }

        // Devolver la lista de tareas como respuesta
        return ResponseEntity.ok(mapOf("status" to "success", "data" to homeworkList))
    }
}
