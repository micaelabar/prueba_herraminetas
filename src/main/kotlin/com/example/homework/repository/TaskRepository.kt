package com.example.homework.repository

import com.example.homework.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface TaskRepository : JpaRepository<Task, Long> {
    fun findByFecha(fecha: LocalDate): List<Task>
}
