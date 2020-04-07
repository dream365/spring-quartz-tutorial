package com.dream365.springquartz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableMongoAuditing

@EnableScheduling
class SpringQuartzApplication

fun main(args: Array<String>) {
    runApplication<SpringQuartzApplication>(*args)
}