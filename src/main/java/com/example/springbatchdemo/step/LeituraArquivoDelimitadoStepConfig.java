package com.example.springbatchdemo.step;

import com.example.springbatchdemo.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraArquivoDelimitadoStepConfig {

    @Bean
    public Step leituraArquivoDelimitadoStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        ItemReader<Cliente> leituraArquivoDelimitadoReader, ItemWriter<Cliente> leituraArquivoDelimitadoWriter) {
        return new StepBuilder("leituraArquivoDelimitadoStep", jobRepository)
            .<Cliente, Cliente>chunk(1, transactionManager)
            .reader(leituraArquivoDelimitadoReader)
            .writer(leituraArquivoDelimitadoWriter)
            .build();
    }

}
