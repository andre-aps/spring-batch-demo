package com.example.step;

import com.example.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SkipErrorStep {

    @Bean
    public Step skipErrorStepItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        ItemReader<Cliente> skipErrorItemReader, ItemWriter<Cliente> skipErrorItemWriter) {
        return new StepBuilder("skipErrorStep", jobRepository)
            .<Cliente, Cliente>chunk(1, transactionManager)
            .reader(skipErrorItemReader)
            .writer(skipErrorItemWriter)
            .faultTolerant()
            .skip(Exception.class)
            .skipLimit(2)
            .build();
    }

}
