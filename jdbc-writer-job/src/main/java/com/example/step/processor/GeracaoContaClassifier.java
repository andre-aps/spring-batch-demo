package com.example.step.processor;

import com.example.domain.Cliente;
import com.example.domain.Conta;
import com.example.domain.TipoConta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class GeracaoContaClassifier implements Classifier<Cliente, ItemProcessor<?, ? extends Conta>> {

    private static final Map<TipoConta, ItemProcessor<Cliente, Conta>> processadores = new HashMap<>() {{
        put(TipoConta.PRATA, new ContaPrataItemProcessor());
        put(TipoConta.OURO, new ContaOuroItemProcessor());
        put(TipoConta.PLATINA, new ContaPlatinaItemProcessor());
        put(TipoConta.DIAMANTE, new ContaDiamanteItemProcessor());
        put(TipoConta.INVALIDA, new ContaInvalidaItemProcessor());
    }};

    @Override
    public ItemProcessor<Cliente, Conta> classify(Cliente cliente) {
        TipoConta tipoConta = TipoConta.fromFaixaSalarial(cliente.getFaixaSalarial());
        return processadores.get(tipoConta);
    }

}
