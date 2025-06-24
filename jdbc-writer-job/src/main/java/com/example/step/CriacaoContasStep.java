package com.example.step;

import com.example.domain.Cliente;
import com.example.domain.Conta;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CriacaoContasStep {

	@Bean
	public Step criacaoContasItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
		ItemReader<Cliente> leituraClientesItemReader,
		ItemProcessor<Cliente, Conta> geracaoContaItemProcessor,
		CompositeItemWriter<Conta> impressaoContaCompositeItemWriter) {
		return new StepBuilder("criacaoContasStep", jobRepository)
			.<Cliente, Conta>chunk(1, transactionManager)
			.reader(leituraClientesItemReader)
			.processor(geracaoContaItemProcessor)
			.writer(impressaoContaCompositeItemWriter)
			.build();
	}

}
