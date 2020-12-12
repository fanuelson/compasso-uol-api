package com.compasso.uol.dao;

import com.compasso.uol.model.Cliente;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.AllowUnusedBindings;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RegisterBeanMapper(Cliente.class)
public interface ClienteDAO {

    @Transaction
    @SqlUpdate("INSERT INTO cliente(nomeCompleto, sexo, dataNascimento, idade, cidadeId) " +
            "VALUES (:nomeCompleto, :sexo, :dataNascimento, :idade, :cidadeId)")
    @GetGeneratedKeys
    Long criar(@BindBean Cliente cliente);

    @SqlQuery("select * from cliente <if(nome)> where nomeCompleto ilike '%' || :nome || '%' <endif> ")
    @AllowUnusedBindings
    List<Cliente> find(@Bind @Define String nome);

    @SqlQuery("select * from cliente where id = ?")
    Optional<Cliente> findById(Long id);

}