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
public class ArquivoLarguraFixaStep {

    @Bean
    public Step arquivoLarguraFixaItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        ItemReader<Cliente> arquivoLarguraFixaItemReader, ItemWriter<Cliente> arquivoLarguraFixaItemWriter) {
        return new StepBuilder("arquivoLarguraFixaStep", jobRepository)
            .<Cliente, Cliente>chunk(1, transactionManager)
            .reader(arquivoLarguraFixaItemReader)
            .writer(arquivoLarguraFixaItemWriter)
            .build();
    }

}
