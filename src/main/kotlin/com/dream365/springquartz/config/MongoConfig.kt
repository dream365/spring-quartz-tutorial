package com.dream365.springquartz.config

import com.mongodb.reactivestreams.client.MongoClient
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.convert.MongoConverter

@Configuration
class MongoConfig {
    @Bean
    fun reactiveMongoDatabaseFactory(mongoClient: MongoClient): SimpleReactiveMongoDatabaseFactory {
        return SimpleReactiveMongoDatabaseFactory(mongoClient, "quartz")
    }

    @Bean
    fun reactiveMongoTemplate(
        @Qualifier("reactiveMongoDatabaseFactory") reactiveMongoDatabaseFactory: ReactiveMongoDatabaseFactory,
        converter: MongoConverter
    ): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoDatabaseFactory, converter)
    }
}