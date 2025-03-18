package com.example.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaJob {

    @Bean
    public Job arquivoLarguraFixaItemJob(JobRepository jobRepository, Step arquivoLarguraFixaStep) {
        return new JobBuilder("arquivoLarguraFixaJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .start(arquivoLarguraFixaStep)
            .build();
    }

}
