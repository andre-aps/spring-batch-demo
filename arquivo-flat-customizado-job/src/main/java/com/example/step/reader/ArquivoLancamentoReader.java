package com.example.step.reader;

import com.example.domain.GrupoLancamento;
import com.example.domain.Lancamento;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLancamentoReader {

    @Bean
    public FlatFileItemReader<GrupoLancamento> arquivoLancamentoItemReader() {
        return new FlatFileItemReaderBuilder<GrupoLancamento>()
            .name("arquivoLancamentoReader")
            .delimited()
            .names("codigoNaturezaDespesa",
                "descricaoNaturezaDespesa",
                "descricaoLancamento",
                "dataLancamento",
                "valorLancamento")
            .fieldSetMapper(grupoLancamentoFieldSetMapper())
            .build();
    }

    private FieldSetMapper<GrupoLancamento> grupoLancamentoFieldSetMapper() {
        return fieldSet -> {
            GrupoLancamento grupo = new GrupoLancamento();
            grupo.setCodigoNaturezaDespesa(fieldSet.readInt("codigoNaturezaDespesa"));
            grupo.setDescricaoNaturezaDespesa(fieldSet.readString("descricaoNaturezaDespesa"));
            grupo.setLancamentoTmp(new Lancamento());
            grupo.getLancamentoTmp().setData(fieldSet.readDate("dataLancamento"));
            grupo.getLancamentoTmp().setDescricao(fieldSet.readString("descricaoLancamento"));
            grupo.getLancamentoTmp().setValor(fieldSet.readDouble("valorLancamento"));
            return grupo;
        };
    }

}
