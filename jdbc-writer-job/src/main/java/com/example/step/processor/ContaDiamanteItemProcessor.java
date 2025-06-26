package com.example.step.processor;

import com.example.domain.Cliente;
import com.example.domain.Conta;
import com.example.domain.TipoConta;
import org.springframework.batch.item.ItemProcessor;

public class ContaDiamanteItemProcessor implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(Cliente cliente) {
        Conta conta = new Conta();
        conta.setClienteId(cliente.getEmail());
        conta.setTipo(TipoConta.DIAMANTE);
        conta.setLimite(5000.0);
        return conta;
    }

}
