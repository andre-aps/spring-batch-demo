package com.example.step;

import com.example.domain.Cliente;
import com.example.domain.Conta;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CriacaoContasStep {

	@Bean
	public Step criacaoContasItemStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
		ItemReader<Cliente> leituraClientesItemReader,
		ItemProcessor<Cliente, Conta> geracaoContaItemProcessor,
		ClassifierCompositeItemWriter<Conta> classifierContaItemWriter,
		@Qualifier("impressaoContaFileItemWriter") FlatFileItemWriter<Conta> impressaoContaFileItemWriter,
		@Qualifier("clienteInvalidoItemWriter") FlatFileItemWriter<Conta> clienteInvalidoItemWriter) {
		return new StepBuilder("criacaoContasStep", jobRepository)
			.<Cliente, Conta>chunk(1, transactionManager)
			.reader(leituraClientesItemReader)
			.processor(geracaoContaItemProcessor)
			.writer(classifierContaItemWriter)
			.stream(impressaoContaFileItemWriter)
			.stream(clienteInvalidoItemWriter)
			.build();
	}

}
