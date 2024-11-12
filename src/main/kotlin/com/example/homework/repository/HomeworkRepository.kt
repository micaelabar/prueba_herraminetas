package com.example.homework.repository

import com.example.homework.entity.Homework // Importar desde el paquete correcto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HomeworkRepository : JpaRepository<Homework, Long> {
}