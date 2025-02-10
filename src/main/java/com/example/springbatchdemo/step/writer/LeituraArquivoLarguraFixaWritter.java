package com.example.springbatchdemo.step.writer;

import com.example.springbatchdemo.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWritter {

    @Bean
    public ItemWriter<Cliente> leituraArquivoLarguraFixaItemWriter() {
        return items -> items.forEach(System.out::println);
    }

}
