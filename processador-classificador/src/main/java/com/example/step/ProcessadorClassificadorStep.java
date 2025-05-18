package com.example.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ProcessadorClassificadorStep {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public Step processadorClassificadorItemStep(JobRepository jobRepository,
                                                 PlatformTransactionManager transactionManager,
                                                 FlatFileItemReader processadorClassificadorItemReader,
                                                 ItemProcessor processadorClassificadorItemProcessor,
                                                 ItemWriter processadorClassificadorItemWriter) {
        return new StepBuilder("processadorClassificadorStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(processadorClassificadorItemReader)
                .processor(processadorClassificadorItemProcessor)
                .writer(processadorClassificadorItemWriter)
                .build();
    }

}
