package com.dream365.springquartz.service

import com.dream365.springquartz.model.Task
import com.dream365.springquartz.repository.TaskRepository
import com.ybrain.klar.backend.logging.ILogging
import com.ybrain.klar.backend.logging.LoggingImpl
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.Instant

@Service
class TaskService(private val taskRepository: TaskRepository) : ILogging by LoggingImpl<TaskService>() {

    fun executeTaskJob(): Mono<Long> {
        log.info("Task job is executed...")

        Thread.sleep(5000)

        return save(Task(content = "Content_" + Instant.now().epochSecond))
            .flatMap { countAll() }
            .doOnNext { cnt -> log.info("COUNT : $cnt") }
    }

    private fun save(task: Task) = taskRepository.save(task)

    private fun countAll() = taskRepository.count()
}