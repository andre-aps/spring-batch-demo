package com.example.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosWritter {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ItemWriter arquivoMultiplosFormatosItemWritter() {
        return items -> items.forEach(System.out::println);
    }

}
