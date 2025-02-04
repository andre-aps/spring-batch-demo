package com.example.springbatchdemo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParOuImparJobConfig {

    @Bean
    public Job parOuImparJob(JobRepository jobRepository, Step parOuImparStep) {
        return new JobBuilder("parOuImparJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .start(parOuImparStep)
            .build();
    }

}
