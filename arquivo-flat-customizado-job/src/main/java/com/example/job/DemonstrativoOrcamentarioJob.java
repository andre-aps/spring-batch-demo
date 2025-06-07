package com.example.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemonstrativoOrcamentarioJob {

    @Bean
    public Job demonstrativoOrcamentarioItemJob(JobRepository jobRepository, Step demonstrativoOrcamentarioStep) {
        return new JobBuilder("demonstrativoOrcamentarioJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .start(demonstrativoOrcamentarioStep)
            .build();
    }

}
