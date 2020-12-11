package com.compasso.uol.service;

import com.compasso.uol.dao.CidadeDAO;
import com.compasso.uol.dtos.CidadeFiltroDTO;
import com.compasso.uol.enums.EstadoEnum;
import com.compasso.uol.model.Cidade;
import com.compasso.uol.service.impl.CidadeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    private static List<Cidade> getCidadesSavedList() {
        Cidade cidade1 = new Cidade();
        cidade1.setId(1L);
        cidade1.setNome("Juiz de Fora");
        cidade1.setEstado(EstadoEnum.MG);

        Cidade cidade2 = new Cidade();
        cidade1.setId(2L);
        cidade1.setNome("São Paulo");
        cidade1.setEstado(EstadoEnum.SP);

        return Arrays.asList(cidade1, cidade2);
    }

    @Test
    public void testSalvarCidade() {

        when(cidadeDAO.criar(Mockito.any())).thenReturn(1L);

        Cidade cidade = getCidadeToSaveMock();
        Cidade cidadeSalva = cidadeServiceImpl.criar(cidade);

        assertEquals(cidadeSalva.getId(), 1L);
    }

    @Test
    public void findCidades_foundResults() {
        when(cidadeDAO.find(Mockito.any())).thenReturn(getCidadesSavedList());

        List<Cidade> cidades = cidadeServiceImpl.find(new CidadeFiltroDTO());

        assertEquals(2, cidades.size());
    }

    @Test
    public void findCidades_emptyResults() {
        when(cidadeDAO.find(Mockito.any())).thenReturn(Collections.emptyList());

        List<Cidade> cidades = cidadeServiceImpl.find(new CidadeFiltroDTO());

        assertEquals(0, cidades.size());
    }

}
