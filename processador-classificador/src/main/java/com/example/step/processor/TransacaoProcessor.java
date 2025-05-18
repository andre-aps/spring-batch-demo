package com.example.step.processor;

import com.example.domain.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {
    @Override
    public Transacao process(Transacao transacao) {
        System.out.printf("Aplicando regra de negócio na transação: %s%n", transacao.getId());
        return transacao;
    }
}
