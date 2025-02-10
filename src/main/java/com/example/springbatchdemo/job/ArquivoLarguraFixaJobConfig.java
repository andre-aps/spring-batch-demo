package com.example.springbatchdemo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaJobConfig {

    @Bean
    public Job arquivoLarguraFixaJob(JobRepository jobRepository, Step leituraArquivoLarguraFixaStep) {
        return new JobBuilder("arquivoLarguraFixaJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .start(leituraArquivoLarguraFixaStep)
            .build();
    }

}
