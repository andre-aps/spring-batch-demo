package com.example.step;

import com.example.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ArquivoMultiplosFormatosStep {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public Step arquivoMultiplosFormatosItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        MultiResourceItemReader<Cliente> multiplosArquivosClienteTransacaoReader, ItemWriter arquivoMultiplosFormatosItemWritter) {
        return new StepBuilder("arquivoMultiplosFormatosStep", jobRepository)
            .<Cliente, Cliente>chunk(1, transactionManager)
            .reader(multiplosArquivosClienteTransacaoReader)
            .writer(arquivoMultiplosFormatosItemWritter)
            .build();
    }

}
