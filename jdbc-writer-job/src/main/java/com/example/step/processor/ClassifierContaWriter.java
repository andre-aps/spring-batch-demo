package com.example.step.processor;

import com.example.domain.Conta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassifierContaWriter {

    @Bean
    public ClassifierCompositeItemWriter<Conta> classifierContaItemWriter(
        @Qualifier("clienteInvalidoItemWriter") FlatFileItemWriter<Conta> clienteInvalidoItemWriter,
        CompositeItemWriter<Conta> impressaoContaFileWriter) {
        return new ClassifierCompositeItemWriterBuilder<Conta>()
            .classifier(classifier(clienteInvalidoItemWriter, impressaoContaFileWriter))
            .build();
    }

    private Classifier<Conta, ItemWriter<? super Conta>> classifier(final FlatFileItemWriter<Conta> clienteInvalidoItemWriter,
        final CompositeItemWriter<Conta> impressaoContaFileWriter) {
        return conta -> {
            if (conta.getTipo() != null)
                return impressaoContaFileWriter;
            else
                return clienteInvalidoItemWriter;
        };
    }

}
