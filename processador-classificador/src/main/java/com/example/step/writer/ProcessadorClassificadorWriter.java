package com.example.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorClassificadorWriter {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ItemWriter ProcessadorClassificadorItemWriter() {
        return items -> items.forEach(System.out::println);
    }

}
