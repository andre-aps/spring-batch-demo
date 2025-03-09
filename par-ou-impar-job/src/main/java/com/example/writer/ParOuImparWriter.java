package com.example.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParOuImparWriter {

    @Bean
    public ItemWriter<String> parOuImparItemWriter() {
        return items -> items.forEach(System.out::println);
    }

}
