package com.example.step.writer;

import com.example.domain.Conta;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ImpressaoContaJdbcWriter {

	@Bean
	public JdbcBatchItemWriter<Conta> impressaoContaJdbcItemWriter(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Conta>()
			.dataSource(dataSource)
			.sql("INSERT INTO conta (tipo, limite, cliente_id) VALUES (?, ?, ?)")
			.itemPreparedStatementSetter(itemPreparedStatementSetter())
			.build();
	}

	private ItemPreparedStatementSetter<Conta> itemPreparedStatementSetter() {
		return (conta, ps) -> {
			ps.setString(1, conta.getTipo().name());
			ps.setDouble(2, conta.getLimite());
			ps.setString(3, conta.getClienteId());
		};
	}

}
