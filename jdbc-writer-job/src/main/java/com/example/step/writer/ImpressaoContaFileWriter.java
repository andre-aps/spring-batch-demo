package com.example.step.writer;

import com.example.domain.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ImpressaoContaFileWriter {

	@Bean
	public FlatFileItemWriter<Conta> impressaoContaFileItemWriter() {
		return new FlatFileItemWriterBuilder<Conta>()
			.name("impressaoContaFileWriter")
			.resource(new FileSystemResource("jdbc-writer-job/src/main/resources/contas.txt"))
			.delimited()
			.names("tipo", "limite", "clienteId")
			.build();
	}

}
