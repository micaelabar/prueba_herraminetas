package com.example.homework.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "tasks")
class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(nullable = false)
    var nombre: String? = null

    @Column(nullable = false)
    var departamento: String? = null

    var fecha: LocalDate? = null

    @Column(name = "hora_entrada")
    var horaEntrada: LocalTime? = null

    @Column(name = "hora_salida")
    var horaSalida: LocalTime? = null
}
