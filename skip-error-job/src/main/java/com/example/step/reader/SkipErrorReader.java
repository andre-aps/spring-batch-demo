package com.example.step.reader;

import com.example.domain.Cliente;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class SkipErrorReader {

    @Bean
    public ItemReader<Cliente> skipErrorItemReader(DataSource dataSource) throws Exception {
        return new JdbcCursorItemReaderBuilder<Cliente>()
            .name("skipErrorReader")
            .dataSource(dataSource)
            .sql("SELECT * FROM cliente")
            .rowMapper(rowMapper())
            .build();
    }

    private RowMapper<Cliente> rowMapper() {
        return (rs, rowNum) -> {
            if (rs.getRow() == 11) {
                throw new SQLException(String.format("Encerrando a execução - Cliente inválido %s", rs.getString("email")));
            }
            return clienteRowMapper(rs);
        };
    }

    private Cliente clienteRowMapper(final ResultSet rs) throws SQLException {
        return new BeanPropertyRowMapper<>(Cliente.class).mapRow(rs, rs.getRow());
    }

}
