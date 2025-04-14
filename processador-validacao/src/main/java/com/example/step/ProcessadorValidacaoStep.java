package com.example.step;

import com.example.domain.Cliente;
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
public class ProcessadorValidacaoStep {

    @Bean
    public Step processadorValidacaoItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        ItemReader<Cliente> processadorValidacaoItemReader, ItemProcessor<Cliente, Cliente> processadorValidacaoItemProcessor,
        ItemWriter<Cliente> processadorValidacaoItemWriter) {
        return new StepBuilder("processadorValidacaoStep", jobRepository)
            .<Cliente, Cliente>chunk(1, transactionManager)
            .reader(processadorValidacaoItemReader)
            .processor(processadorValidacaoItemProcessor)
            .writer(processadorValidacaoItemWriter)
            .build();
    }

}
