package com.example.springbatchdemo.step.reader;

import com.example.springbatchdemo.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoDelimitadoReader {

    @Bean
    @StepScope
    @Primary
    public FlatFileItemReader<Cliente> leituraArquivoDelimitadoItemReader(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
        return new FlatFileItemReaderBuilder<Cliente>()
            .name("leituraArquivoDelimitadoItemReader")
            .resource(arquivoClientes)
            .delimited()
            .names("nome", "sobrenome", "idade", "email")
            .targetType(Cliente.class)
            .build();
    }

}
