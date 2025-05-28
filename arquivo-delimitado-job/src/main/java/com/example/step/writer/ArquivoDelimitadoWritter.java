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
public class ArquivoDelimitadoWritter {

    @StepScope
    @Bean
    public FlatFileItemWriter<Cliente> arquivoDelimitadoItemWriter(
        @Value("#{jobParameters['arquivoClientesSaida']}") WritableResource arquivoClientesSaida) {
        return new FlatFileItemWriterBuilder<Cliente>()
            .name("arquivoDelimitadoItemWriter")
            .resource(arquivoClientesSaida)
            .delimited()
            .names("nome", "sobrenome", "idade", "email")
            .build();
    }

}
