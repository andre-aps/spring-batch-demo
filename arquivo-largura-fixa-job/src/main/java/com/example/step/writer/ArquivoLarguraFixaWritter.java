package com.example.step.writer;

import com.example.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaWritter {

    @Bean
    public ItemWriter<Cliente> arquivoLarguraFixaItemWriter() {
        return items -> items.forEach(System.out::println);
    }

}
