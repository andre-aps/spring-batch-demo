package com.example.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ParOuImparStep {

    @Bean
    public Step parOuImparItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        ItemReader<Integer> parOuImparItemReader, ItemProcessor<Integer, String> parOuImparItemProcessor, ItemWriter<String> parOuImparItemWriter) {
        return new StepBuilder("parOuImparStep", jobRepository)
            .<Integer, String>chunk(1, transactionManager)
            .reader(parOuImparItemReader)
            .processor(parOuImparItemProcessor)
            .writer(parOuImparItemWriter)
            .build();
    }

}
