package com.dream365.springquartz.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "tasks")
data class Task(@Id var id: String? = null,
                val content: String,
                @CreatedDate var createDate: Instant? = null,
                @LastModifiedDate var modifiedDate: Instant? = null)