package com.example.step.processor;

import com.example.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorClassificadorProcessor {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ItemProcessor ProcessadorClassificadorItemProcessor() {
        return new ClassifierCompositeItemProcessorBuilder<>()
                .classifier(classifier())
                .build();
    }

    @SuppressWarnings({"rawtypes"})
    private Classifier classifier() {
        return new Classifier<Object, ItemProcessor>() {
            @Override
            public ItemProcessor classify(Object object) {
                if (object instanceof Cliente) {
                    return new ClienteProcessor();
                } else {
                    return new TransacaoProcessor();
                }
            }
        };
    }

}
