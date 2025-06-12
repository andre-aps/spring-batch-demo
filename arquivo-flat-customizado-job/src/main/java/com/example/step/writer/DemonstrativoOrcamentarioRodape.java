package com.example.step.writer;

import com.example.domain.GrupoLancamento;
import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;

@Component
public class DemonstrativoOrcamentarioRodape implements FlatFileFooterCallback {

    private Double totalGeral = 0.0;

    @Override
    public void writeFooter(final Writer writer) throws IOException {
        writer.append(String.format("\t\t\t\t\t\t\t  Total: %s\n", NumberFormat.getCurrencyInstance().format(totalGeral)));
        writer.append(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s", "fkyew6868fewjfhjjewf"));
    }

    @BeforeWrite
    public void beforeWrite(Chunk<? extends GrupoLancamento> grupos) {
        for (GrupoLancamento grupoLancamento : grupos.getItems()) {
            totalGeral += grupoLancamento.getTotal();
        }
    }

    @AfterChunk
    public void afterChunk(ChunkContext chunkContext) {
        totalGeral = 0.0;
    }

}
