package com.example.step.writer;

import com.example.domain.Conta;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImpressaoContaCompositeWriter {

	@Bean
	public CompositeItemWriter<Conta> impressaoContaCompositeItemWriter(
		@Qualifier("impressaoContaFileItemWriter") FlatFileItemWriter<Conta> flatFileItemWriter,
		JdbcBatchItemWriter<Conta> jdbcBatchItemWriter) {
		return new CompositeItemWriterBuilder<Conta>()
			.delegates(flatFileItemWriter, jdbcBatchItemWriter)
			.build();
	}

}
