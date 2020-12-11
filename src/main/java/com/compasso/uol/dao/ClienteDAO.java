package com.compasso.uol.dao;

import com.compasso.uol.model.Cliente;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RegisterBeanMapper(Cliente.class)
public interface ClienteDAO {

    @Transaction
    @SqlUpdate("INSERT INTO cliente(nomeCompleto, sexo, dataNascimento, idade, cidadeId) " +
            "VALUES (:nomeCompleto, :sexo, :dataNascimento, :idade, :cidadeId)")
    @GetGeneratedKeys
    Long criar(@BindBean Cliente cliente);

}