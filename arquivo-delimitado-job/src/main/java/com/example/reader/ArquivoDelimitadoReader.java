package com.example.reader;

import com.example.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoDelimitadoReader {

    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> arquivoDelimitadoItemReader(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
        return new FlatFileItemReaderBuilder<Cliente>()
            .name("arquivoDelimitadoReader")
            .resource(arquivoClientes)
            .delimited()
            .names("nome", "sobrenome", "idade", "email")
            .targetType(Cliente.class)
            .build();
    }

}
