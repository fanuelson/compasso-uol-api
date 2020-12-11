package com.compasso.uol.config;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbiConfiguration {

    @Bean
    public Jdbi jdbi(DataSource dataSource){
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        jdbi.installPlugin(new SqlObjectPlugin());

        // just for testing, create an in-memory table:
        jdbi.useHandle(h -> h.execute("create table cidade (id integer primary key auto_increment, nome varchar, estado varchar)"));

        return jdbi;
    }
}
