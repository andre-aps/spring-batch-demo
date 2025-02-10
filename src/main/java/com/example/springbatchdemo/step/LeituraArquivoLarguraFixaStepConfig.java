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
public class LeituraArquivoLarguraFixaStepConfig {

    @Bean
    public Step leituraArquivoLarguraFixaStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        ItemReader<Cliente> leituraArquivoLarguraFixaReader, ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {
        return new StepBuilder("leituraArquivoLarguraFixaStep", jobRepository)
            .<Cliente, Cliente>chunk(1, transactionManager)
            .reader(leituraArquivoLarguraFixaReader)
            .writer(leituraArquivoLarguraFixaWriter)
            .build();
    }

}
