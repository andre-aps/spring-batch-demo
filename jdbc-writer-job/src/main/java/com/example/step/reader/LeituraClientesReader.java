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
public class LeituraClientesReader {

    @Bean
    public JdbcPagingItemReader<Cliente> leituraClientesItemReader(DataSource dataSource, PagingQueryProvider queryProvider) {
        return new JdbcPagingItemReaderBuilder<Cliente>()
            .name("leituraClientesReader")
            .dataSource(dataSource)
            .queryProvider(queryProvider)
            .rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
            .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("SELECT *");
        queryProvider.setFromClause("FROM cliente");
        queryProvider.setSortKey("email");
        return queryProvider;
    }

}
