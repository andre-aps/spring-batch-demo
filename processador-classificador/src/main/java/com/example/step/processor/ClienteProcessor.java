package com.example.step.processor;

import com.example.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

    @Override
    public Cliente process(Cliente cliente) {
        System.out.printf("Aplicando regra de negócio no cliente: %s%n", cliente.getEmail());
        return cliente;
    }

}
