package com.compasso.uol.dao;

import com.compasso.uol.dtos.CidadeFiltroDTO;
import com.compasso.uol.model.Cidade;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.AllowUnusedBindings;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.DefineNamedBindings;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RegisterBeanMapper(Cidade.class)
public interface CidadeDAO {

        @Transaction
        @SqlUpdate("INSERT INTO cidade(nome, estado) VALUES (:nome, :estado)")
        @GetGeneratedKeys
        Long criar(@BindBean Cidade cidade);

        @SqlQuery("select * from cidade where 1=1" +
                "<if(nome)> and nome ilike '%' || :nome || '%' <endif> " +
                "<if(estado)> and estado ilike '%' || :estado || '%' <endif> ")
        @AllowUnusedBindings
        @DefineNamedBindings
        List<Cidade> find(@BindBean CidadeFiltroDTO cidadeFiltroDTO);

}
