package com.example.step.writer;

import com.example.domain.GrupoLancamento;
import com.example.domain.Lancamento;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.WritableResource;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class DemonstrativoOrcamentarioWriter {

    @Bean
    @StepScope
    public FlatFileItemWriter<GrupoLancamento> demonstrativoOrcamentarioItemWriter(
        @Value("#{jobParameters['demonstrativoOrcamentario']}") WritableResource demonstrativoOrcamentario,
        DemonstrativoOrcamentarioRodape rodapeCallback) throws IOException {
        return new FlatFileItemWriterBuilder<GrupoLancamento>()
            .name("demonstrativoOrcamentarioWriter")
            .resource(demonstrativoOrcamentario)
            .lineAggregator(lineAggregator())
            .headerCallback(cabecalhoCallback())
            .footerCallback(rodapeCallback)
            .build();
    }

    private FlatFileHeaderCallback cabecalhoCallback() {
        return writer -> {
            writer.append(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s\n", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
            writer.append(String.format("MÓDULO: ORÇAMENTO \t\t\t\t\t\t HORA: %s\n", new SimpleDateFormat("HH:MM").format(new Date())));
            writer.append(String.format("\t\t\tDEMONSTRATIVO ORCAMENTARIO\n"));
            writer.append(String.format("----------------------------------------------------------------------------\n"));
            writer.append(String.format("CODIGO NOME VALOR\n"));
            writer.append(String.format("\t Data Descricao Valor\n"));
            writer.append(String.format("----------------------------------------------------------------------------\n"));
        };
    }

    private LineAggregator<GrupoLancamento> lineAggregator() {
        return grupoLancamento -> {
            String formatoGrupoLancamento = String.format("[%d] %s - %s\n",
                grupoLancamento.getCodigoNaturezaDespesa(),
                grupoLancamento.getDescricaoNaturezaDespesa(),
                NumberFormat.getCurrencyInstance().format(grupoLancamento.getTotal()));

            StringBuilder stringBuilder = new StringBuilder();
            for (Lancamento lancamento : grupoLancamento.getLancamentos()) {
                stringBuilder.append(
                    String.format("\t [%s] %s - %s\n", new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()), lancamento.getDescricao(),
                        NumberFormat.getCurrencyInstance().format(lancamento.getValor())));
            }
            String formatoLancamento = stringBuilder.toString();
            return formatoGrupoLancamento + formatoLancamento;
        };
    }

}
