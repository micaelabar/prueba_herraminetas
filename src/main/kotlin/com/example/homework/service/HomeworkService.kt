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

    fun save(homeworkDto: HomeworkDto, bindingResult: BindingResult): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            val errorMessages = bindingResult.allErrors.map { it.defaultMessage }.joinToString(", ")
            return ResponseEntity.badRequest().body(mapOf("status" to "error", "message" to errorMessages))
        }

        val homework = homeworkMapper.toEntity(homeworkDto)
        val savedHomework = homeworkRepository.save(homework)
        return ResponseEntity.ok(mapOf("status" to "success", "data" to homeworkMapper.toDto(savedHomework)))
    }

    fun getHomework(): ResponseEntity<Any> {
        val homeworkList = homeworkRepository.findAll().map { homeworkMapper.toDto(it) }
        return ResponseEntity.ok(mapOf("status" to "success", "data" to homeworkList))
    }
}