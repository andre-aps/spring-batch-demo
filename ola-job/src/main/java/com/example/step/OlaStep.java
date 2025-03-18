package com.example.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class OlaStep {

    @Bean
    public Step olaItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager, Tasklet olaTasklet) {
        return new StepBuilder("olaStep", jobRepository)
            .tasklet(olaTasklet, transactionManager)
            .build();
    }

}
