package com.example.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcCursorJob {

    @Bean
    public Job jdbcCursorItemJob(JobRepository jobRepository, Step jdbcCursorStep) {
        return new JobBuilder("jdbcCursorJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .start(jdbcCursorStep)
            .build();
    }

}
