package com.example.step;

import com.example.domain.Cliente;
import com.example.step.reader.ClienteTransacaoReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ArquivoMultiplosFormatosStep {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public Step arquivoMultiplosFormatosItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        FlatFileItemReader arquivoMultiplosFormatosItemReader, ItemWriter arquivoMultiplosFormatosItemWritter) {
        return new StepBuilder("arquivoMultiplosFormatosStep", jobRepository)
            .<Cliente, Cliente>chunk(1, transactionManager)
            .reader(new ClienteTransacaoReader(arquivoMultiplosFormatosItemReader))
            .writer(arquivoMultiplosFormatosItemWritter)
            .build();
    }

}
