package com.dream365.springquartz.scheduler

import com.dream365.springquartz.config.AutoWiringSpringBeanJobFactory
import com.ybrain.klar.backend.logging.ILogging
import com.ybrain.klar.backend.logging.LoggingImpl
import org.quartz.JobDetail
import org.quartz.Trigger
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.scheduling.quartz.CronTriggerFactoryBean
import org.springframework.scheduling.quartz.JobDetailFactoryBean
import org.springframework.scheduling.quartz.SchedulerFactoryBean
import org.springframework.scheduling.quartz.SpringBeanJobFactory
import java.util.*


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

    /**
     * A Trigger is the mechanism to schedule a Job, i.e. a Trigger instance “fires” the execution of a job.
     * There's a clear separation of responsibilities between the Job (notion of task) and Trigger (scheduling mechanism).
     **/
    @Bean
    fun cronTrigger(job: JobDetail): CronTriggerFactoryBean {
        val trigger = CronTriggerFactoryBean()
        trigger.setJobDetail(job)

        log.info("Configuring cron trigger to fire every 5 seconds")
        trigger.setCronExpression("0/5 * * 1/1 * ? *")
        trigger.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"))
        trigger.setName("Qrtz_Cron_Trigger")
        return trigger
    }

    /*
    @Bean
    fun simpleTrigger(job: JobDetail?): SimpleTriggerFactoryBean? {
        val trigger = SimpleTriggerFactoryBean()
        trigger.setJobDetail(job)
        val frequencyInSec = 10
        log.info("Configuring trigger to fire every {} seconds", frequencyInSec)
        trigger.setRepeatInterval(frequencyInSec * 1000.toLong())
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
        trigger.setName("Qrtz_Simple_Trigger")
        return trigger
    }*/

}