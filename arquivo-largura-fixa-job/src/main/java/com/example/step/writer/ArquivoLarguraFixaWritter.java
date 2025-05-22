package com.example.step.writer;

import com.example.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.WritableResource;

@Configuration
public class ArquivoLarguraFixaWritter {

    @StepScope
    @Bean
    public FlatFileItemWriter<Cliente> arquivoLarguraFixaItemWriter(
        @Value("#{jobParameters['arquivoClientesSaida']}") WritableResource arquivoClientesSaida) {
        return new FlatFileItemWriterBuilder<Cliente>()
            .name("arquivoLarguraFixaItemWriter")
            .resource(arquivoClientesSaida)
            .formatted()
            .format("%-9s %-9s %-2s %-19s")
            .names("nome", "sobrenome", "idade", "email")
            .build();
    }

}
