package com.example.step.reader;

import com.example.domain.GrupoLancamento;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DemonstrativoOrcamentarioReader {

    @StepScope
    @Bean
    public MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioItemReader(
        @Value("#{jobParameters['arquivosLancamento']}") Resource[] arquivosLancamento, GrupoLancamentoReader grupoLancamentoReader) {
        return new MultiResourceItemReaderBuilder<GrupoLancamento>()
            .name("demonstrativoOrcamentarioReader")
            .resources(arquivosLancamento)
            .delegate(grupoLancamentoReader)
            .build();
    }

}
