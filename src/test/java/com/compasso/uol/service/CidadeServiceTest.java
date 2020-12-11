package com.compasso.uol.service;

import com.compasso.uol.dao.CidadeDAO;
import com.compasso.uol.enums.EstadoEnum;
import com.compasso.uol.model.Cidade;
import com.compasso.uol.service.impl.CidadeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CidadeServiceTest {

    @Mock
    private CidadeDAO cidadeDAO;

    @InjectMocks
    private CidadeServiceImpl cidadeServiceImpl;

    private static Cidade getCidadeToSaveMock() {
        Cidade cidade = new Cidade();
        cidade.setNome("Juiz de Fora");
        cidade.setEstado(EstadoEnum.MG);
        return cidade;
    }

    @Test
    public void testSalvarCidade() {

        when(cidadeDAO.criar(Mockito.any())).thenReturn(1L);

        Cidade cidade = getCidadeToSaveMock();
        Cidade cidadeSalva = cidadeServiceImpl.criar(cidade);

        assertEquals(cidadeSalva.getId(), 1L);
    }

}
