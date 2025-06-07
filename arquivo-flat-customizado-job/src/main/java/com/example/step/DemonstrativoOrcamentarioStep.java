package com.example.step;

import com.example.domain.GrupoLancamento;
import com.example.step.writer.DemonstrativoOrcamentarioRodape;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DemonstrativoOrcamentarioStep {

    @Bean
    public Step demonstrativoOrcamentarioItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
        MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioItemReader,
        ItemWriter<GrupoLancamento> demonstrativoOrcamentarioItemWriter, DemonstrativoOrcamentarioRodape rodapeCallback) {
        return new StepBuilder("demonstrativoOrcamentarioStep", jobRepository)
            .<GrupoLancamento, GrupoLancamento>chunk(1, transactionManager)
            .reader(demonstrativoOrcamentarioItemReader)
            .writer(demonstrativoOrcamentarioItemWriter)
            .listener(rodapeCallback)
            .build();
    }

}
