package com.example.homework.controller

import com.example.homework.dto.HomeworkDto
import com.example.homework.service.HomeworkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/homework")
class HomeworkController {

    @Autowired
    lateinit var homeworkService: HomeworkService

    @PostMapping("/save")
    fun save(@RequestBody @Validated homeworkDto: HomeworkDto, bindingResult: BindingResult): ResponseEntity<Any> {
        return homeworkService.save(homeworkDto, bindingResult)
    }

    @GetMapping("/list")
    fun getHomework(): ResponseEntity<Any> {
        return homeworkService.getHomework()
    }
}