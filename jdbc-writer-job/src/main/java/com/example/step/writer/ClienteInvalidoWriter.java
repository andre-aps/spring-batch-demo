package com.example.step.writer;

import com.example.domain.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ClienteInvalidoWriter {

	@Bean
	public FlatFileItemWriter<Conta> clienteInvalidoItemWriter() {
		return new FlatFileItemWriterBuilder<Conta>()
			.name("clienteInvalidoWriter")
			.resource(new FileSystemResource("jdbc-writer-job/src/main/resources/clientesInvalidos.txt"))
			.delimited()
			.names("clienteId")
			.build();
	}

}
