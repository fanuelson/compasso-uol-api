package com.compasso.uol.service;

import com.compasso.uol.dao.ClienteDAO;
import com.compasso.uol.enums.SexoEnum;
import com.compasso.uol.exceptions.ApiException;
import com.compasso.uol.model.Cliente;
import com.compasso.uol.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClienteServiceTest {

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

    private static List<Cliente> getClientesSavedList() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNomeCompleto("Test John1");
        cliente1.setSexo(SexoEnum.MASCULINO);
        cliente1.setDataNascimento(LocalDate.of(1994, 10, 10));
        cliente1.setIdade(26);
        cliente1.setCidadeId(1L);

        Cliente cliente2 = new Cliente();
        cliente2.setId(1L);
        cliente2.setNomeCompleto("Test John2");
        cliente2.setSexo(SexoEnum.MASCULINO);
        cliente2.setDataNascimento(LocalDate.of(1994, 10, 10));
        cliente2.setIdade(26);
        cliente2.setCidadeId(1L);

        return Arrays.asList(cliente1, cliente2);
    }

    @Test
    void testSalvarCliente() {

        when(clienteDAO.criar(Mockito.any())).thenReturn(1L);

        Cliente clienteToSave = getClienteToSaveMock();
        Cliente clienteSalvo = clienteServiceImpl.criar(clienteToSave);

        assertEquals(clienteSalvo.getId(), 1L);
    }

    @Test
    void findClientes_FoundResults() {
        when(clienteDAO.find(Mockito.any())).thenReturn(getClientesSavedList());

        List<Cliente> clientes = clienteServiceImpl.find("teste");

        assertEquals(2, clientes.size());
    }

    @Test
    void findClientes_EmptyResults() {
        when(clienteDAO.find(Mockito.any())).thenReturn(Collections.emptyList());

        List<Cliente> clientes = clienteServiceImpl.find("qualquer nome que não existe");

        assertEquals(0, clientes.size());
    }

    @Test
    void findClienteById_Found() {
        Cliente clienteSaved = getClientesSavedList().get(0);

        when(clienteDAO.findById(clienteSaved.getId())).thenReturn(Optional.of(clienteSaved));

        Cliente clienteEncontrado = clienteServiceImpl.findById(clienteSaved.getId());

        assertEquals(clienteEncontrado.getId(), clienteSaved.getId());
    }

    @Test
    void findClienteById_NotFound() {

        when(clienteDAO.findById(Mockito.any())).thenReturn(Optional.empty());

        assertThrows(ApiException.class, () -> clienteServiceImpl.findById(123L));

    }

    @Test
    void deletarCliente_ClienteExiste() {

        when(clienteDAO.delete(Mockito.anyLong())).thenReturn(true);
        boolean deleted = clienteServiceImpl.delete(1L);

        assertTrue(deleted);
        verify(clienteDAO, Mockito.times(1)).delete(1L);
    }

    @Test
    void deletarCliente_ClienteNaoExiste() {
        when(clienteDAO.delete(Mockito.anyLong())).thenReturn(false);

        assertThrows(ApiException.class, () -> clienteServiceImpl.delete(1L));
    }
}
