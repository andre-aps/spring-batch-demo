package com.example.step.reader;

import com.example.domain.Cliente;
import com.example.domain.Transacao;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

public class ClienteTransacaoReader implements ItemStreamReader<Cliente> {

    private Object objetoAtual;
    private ItemStreamReader<Object> delegate;

    public ClienteTransacaoReader(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void open(final ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(final ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public Cliente read() throws Exception {
        if (objetoAtual == null) {
            objetoAtual = delegate.read();
        }

        Cliente cliente = (Cliente) objetoAtual;
        objetoAtual = null;

        if (cliente != null) {
            while (peek() instanceof Transacao) {
                cliente.getTransacoes().add((Transacao) objetoAtual);
            }
        }
        return cliente;
    }

    private Object peek() throws Exception {
        objetoAtual = delegate.read();
        return objetoAtual;
    }

}
