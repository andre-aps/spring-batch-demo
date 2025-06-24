package com.example.step.processor;

import com.example.domain.Cliente;
import com.example.domain.Conta;
import com.example.domain.TipoConta;
import org.springframework.batch.item.ItemProcessor;

public class ContaPlatinaItemProcessor implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(Cliente cliente) throws Exception {
        Conta conta = new Conta();
        conta.setClienteId(cliente.getEmail());
        conta.setTipo(TipoConta.PLATINA);
        conta.setLimite(2500.0);
        return conta;
    }

}
