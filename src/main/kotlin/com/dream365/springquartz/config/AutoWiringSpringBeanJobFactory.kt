package com.dream365.springquartz.config

import org.quartz.spi.TriggerFiredBundle
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.scheduling.quartz.SpringBeanJobFactory

class AutoWiringSpringBeanJobFactory: SpringBeanJobFactory(), ApplicationContextAware {
    @Transient
    private lateinit var beanFactory: AutowireCapableBeanFactory

    fun setUpApplicationContext(applicationContext: ApplicationContext) {
        beanFactory = applicationContext.autowireCapableBeanFactory
    }

    override fun createJobInstance(bundle: TriggerFiredBundle): Any {
        val job: Any = super.createJobInstance(bundle)

        beanFactory.autowireBean(job)

        return job
    }
}