package com.example.step.reader;

import com.example.domain.Cliente;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReader {

    @Bean
    public JdbcCursorItemReader<Cliente> jdbcCursorItemReader(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Cliente>()
            .name("jdbcCursorReader")
            .dataSource(dataSource)
            .sql("select * from cliente")
            .rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
            .build();
    }

}
