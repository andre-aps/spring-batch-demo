package com.example.step.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParOuImparProcessor {

    @Bean
    public ItemProcessor<Integer, String> parOuImparItemProcessor() {
        return new FunctionItemProcessor<>(item -> item % 2 == 0 ? String.format("item %s é par", item) : String.format("item %s é ímpar", item));
    }

}
