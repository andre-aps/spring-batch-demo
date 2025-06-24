package com.example.step.processor;

import com.example.domain.Cliente;
import com.example.domain.Conta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeracaoContaProcessor {

    @Bean
    public ItemProcessor<Cliente, Conta> geracaoContaItemProcessor() {
        return new ClassifierCompositeItemProcessorBuilder<Cliente, Conta>()
            .classifier(new GeracaoContaClassifier())
            .build();
    }

}
