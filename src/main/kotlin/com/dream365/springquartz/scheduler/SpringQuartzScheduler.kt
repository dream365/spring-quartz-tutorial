package com.dream365.springquartz.scheduler

import com.ybrain.klar.backend.logging.ILogging
import com.ybrain.klar.backend.logging.LoggingImpl
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.quartz.JobDetailFactoryBean


/** @see <a href="https://www.baeldung.com/spring-quartz-schedule">Scheduling in Spring with Quartz</a> **/
@Configuration
class SpringQuartzScheduler : ILogging by LoggingImpl<SpringQuartzScheduler>() {

    /**
     * While the job is the workhorse, Quartz does not store an actual instance of the job class.
     * Instead, we can define an instance of the Job using the JobDetail class.
     * The job's class must be provided to the JobDetail so that it knows the type of the job to be executed.
     **/
    @Bean
    fun jobDetail(): JobDetailFactoryBean {
        val jobDetailFactory = JobDetailFactoryBean()
        jobDetailFactory.setJobClass(SampleJob::class.java)
        jobDetailFactory.setName("Sample_Qrtz_Job_Detail")
        jobDetailFactory.setDescription("Invoke Sample Job service...")
        jobDetailFactory.setDurability(true)
        return jobDetailFactory
    }


    // Builder-style API
    /*@Bean
    fun jobDetail(): JobDetail {
        return JobBuilder.newJob().ofType(SampleJob::class.java)
            .storeDurably()
            .withIdentity("Qrtz_Job_Detail")
            .withDescription("Invoke Sample Job service...")
            .build()
    }*/


}