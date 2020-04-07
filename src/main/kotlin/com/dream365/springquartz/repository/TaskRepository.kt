package com.dream365.springquartz.repository

import com.dream365.springquartz.model.Task
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : ReactiveMongoRepository<Task, String>
