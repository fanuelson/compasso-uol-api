package com.compasso.uol.service;

import com.compasso.uol.dao.ClienteDAO;
import com.compasso.uol.enums.SexoEnum;
import com.compasso.uol.model.Cliente;
import com.compasso.uol.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private ClienteDAO clienteDAO;

    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;

    private static Cliente getClienteToSaveMock() {
        Cliente cliente = new Cliente();
        cliente.setNomeCompleto("Test John");
        cliente.setSexo(SexoEnum.MASCULINO);
        cliente.setDataNascimento(LocalDate.of(1994, 10, 10));
        cliente.setIdade(26);
        cliente.setCidadeId(1L);
        return cliente;
    }

    @Test
    public void testSalvarCidade() {

        when(clienteDAO.criar(Mockito.any())).thenReturn(1L);

        Cliente clienteToSave = getClienteToSaveMock();
        Cliente clienteSalvo = clienteServiceImpl.criar(clienteToSave);

        assertEquals(clienteSalvo.getId(), 1L);
    }
}
