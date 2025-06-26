package com.example.step.processor;

import com.example.domain.Cliente;
import com.example.domain.Conta;
import org.springframework.batch.item.ItemProcessor;

public class ContaInvalidaItemProcessor implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(final Cliente cliente) {
        Conta conta = new Conta();
        conta.setClienteId(cliente.getEmail());
        return conta;
    }

}
