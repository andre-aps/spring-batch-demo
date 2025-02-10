package com.example.springbatchdemo.step.writer;

import com.example.springbatchdemo.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LeituraArquivoDelimitadoWritter {

    @Bean
    @Primary
    public ItemWriter<Cliente> leituraArquivoDelimitadoItemWriter() {
        return items -> items.forEach(System.out::println);
    }

}
