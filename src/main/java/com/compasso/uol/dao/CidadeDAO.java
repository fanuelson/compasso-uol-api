package com.compasso.uol.dao;

import com.compasso.uol.model.Cidade;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RegisterBeanMapper(Cidade.class)
public interface CidadeDAO {

        @Transaction
        @SqlUpdate("INSERT INTO cidade(nome, estado) VALUES (:nome,:estado)")
        @GetGeneratedKeys
        Long criar(@BindBean Cidade cidade);

}
