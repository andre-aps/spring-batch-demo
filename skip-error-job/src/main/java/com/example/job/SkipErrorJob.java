package com.example.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SkipErrorJob {

    @Bean
    public Job skipErrorItemJob(JobRepository jobRepository, Step skipErrorStep) {
        return new JobBuilder("skipErrorJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .start(skipErrorStep)
            .build();
    }

}
