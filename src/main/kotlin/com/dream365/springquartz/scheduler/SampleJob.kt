package com.dream365.springquartz.scheduler

import com.dream365.springquartz.service.TaskService
import com.ybrain.klar.backend.logging.ILogging
import com.ybrain.klar.backend.logging.LoggingImpl
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.stereotype.Component


/*
The API provides a Job interface having just one method – execute.
It must be implemented by the class that contains the actual work to be done, i.e. the task.
When a job's trigger fires, the scheduler invokes the execute method, passing it a JobExecutionContext object.

The JobExecutionContext provides the job instance with information about its runtime environment,
including a handle to the scheduler, a handle to the trigger, and the job's JobDetail object.
@see <a href="https://www.baeldung.com/spring-quartz-schedule">Scheduling in Spring with Quartz</a>
*/
@Component
class SampleJob(private val taskService: TaskService): Job, ILogging by LoggingImpl<SampleJob>() {
    override fun execute(context: JobExecutionContext) {
        log.info("Job {} fired at {}", context.jobDetail.key.name, context.fireTime)

        taskService.executeTaskJob().subscribe()

        log.info("Next job scheduled at {}", context.nextFireTime)
    }
}