package com.dream365.springquartz.service

import com.dream365.springquartz.model.Task
import com.dream365.springquartz.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun save(task: Task) = taskRepository.save(task)

    fun countAll() = taskRepository.count()
}