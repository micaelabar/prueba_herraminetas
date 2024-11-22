package com.example.homework.mapper

import com.example.homework.entity.Homework
import com.example.homework.dto.HomeworkDto
import org.springframework.stereotype.Component

@Component
class HomeworkMapper {

    fun toDto(entity: Homework): HomeworkDto {
        return HomeworkDto(
            id = entity.id, // Esto debe existir en la clase Homework
            nombreTarea = entity.nombreTarea,
            descripcion = entity.descripcion,
            fechaEntrega = entity.fechaEntrega,
            estado = entity.estado
        )
    }

    fun toEntity(dto: HomeworkDto): Homework {
        return Homework(
            id = dto.id, // Esto debe existir en la clase HomeworkDto
            nombreTarea = dto.nombreTarea,
            descripcion = dto.descripcion,
            fechaEntrega = dto.fechaEntrega,
            estado = dto.estado
        )
    }
}
