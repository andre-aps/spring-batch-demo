package com.example.step.processor;

import com.example.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProcessadorValidacaoProcessor {

    private Set<String> emails = new HashSet<>();

    @Bean
    public ItemProcessor<Cliente, Cliente> processadorValidacaoItemProcessor() throws Exception {
        return new CompositeItemProcessorBuilder<Cliente, Cliente>()
            .delegates(beanValidatingItemProcessor(), emailValidatingProcessor())
            .build();
    }

    private BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor() throws Exception {
        BeanValidatingItemProcessor<Cliente> processor = new BeanValidatingItemProcessor<>();
        processor.setFilter(true);
        processor.afterPropertiesSet();
        return processor;
    }

    private ValidatingItemProcessor<Cliente> emailValidatingProcessor() {
        ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
        processor.setValidator(validator());
        processor.setFilter(true);
        return processor;
    }

    private Validator<? super Cliente> validator() {
        return (Validator<Cliente>) cliente -> {
            if (emails.contains(cliente.getEmail())) {
                throw new ValidationException("O cliente %s já foi processado!");
            }
            emails.add(cliente.getEmail());
        };
    }

}
