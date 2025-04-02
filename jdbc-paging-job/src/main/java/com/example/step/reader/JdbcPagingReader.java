package com.example.step.reader;

import com.example.domain.Cliente;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcPagingReader {

    @Bean
    public JdbcPagingItemReader<Cliente> jdbcPagingItemReader(DataSource dataSource, PagingQueryProvider queryProvider) {
        return new JdbcPagingItemReaderBuilder<Cliente>()
            .name("jdbcPagingReader")
            .dataSource(dataSource)
            .queryProvider(queryProvider)
            .pageSize(1)
            .rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
            .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean factory = new SqlPagingQueryProviderFactoryBean();
        factory.setDataSource(dataSource);
        factory.setSelectClause("SELECT *");
        factory.setFromClause("FROM cliente");
        factory.setSortKey("email");
        return factory;
    }

}
