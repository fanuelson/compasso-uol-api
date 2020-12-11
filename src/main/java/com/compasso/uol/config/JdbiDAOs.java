package com.compasso.uol.config;

import com.compasso.uol.dao.CidadeDAO;
import com.compasso.uol.dao.ClienteDAO;
import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbiDAOs {

    @Bean
    public CidadeDAO cidadeDao(Jdbi jdbi) {
        return jdbi.onDemand(CidadeDAO.class);
    }

    @Bean
    public ClienteDAO clienteDao(Jdbi jdbi) {
        return jdbi.onDemand(ClienteDAO.class);
    }
}
