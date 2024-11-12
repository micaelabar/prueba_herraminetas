package com.example.homework.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Entity
@Table(name = "tareas")
data class Homework(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotNull(message = "El nombre de la tarea no puede ser nulo")
    var nombreTarea: String?,

    var descripcion: String? = null,

    @field:NotNull(message = "La fecha de entrega no puede ser nula")
    var fechaEntrega: LocalDateTime?,

    @field:NotNull(message = "El estado no puede ser nulo")
    var estado: Boolean?
)