package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest1 {
	
	/**
	 * Classe de teste para testar operacoes de {@link GerenciadoraClientes}
	 * 
	 *  @author Daniel Bastos
	 *  @date 10/03/2023
	 */
	
	private GerenciadoraClientes gerClientes;

	@Test
	public void testPesquisaCliente() {
		// Criação de cenário
		int idCliente01 = 1;
		int idCliente02 = 2;
		
		int idContaCorrente01 =1;
		int idContaCorrente02 =2;
		
		Cliente cliente1 = new Cliente(1,"Joao",46,"joao@gmail.com",1,true);
		Cliente cliente2 = new Cliente(2,"Maria",11,"maria@gmail.com",2,true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		
		gerClientes = new GerenciadoraClientes(clientes);
		
		//execucao do teste
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		//verificacao do resultado
		assertThat(cliente.getId(), is(idCliente01));
	}
	
	public void testRemoveCliente() {
		// TODO Auto-generated method stub
		int idCliente01 = 1;
		int idCliente02 = 2;
		
		int idContaCorrente01 =1;
		int idContaCorrente02 =2;
		
		Cliente cliente1 = new Cliente(idCliente01,"Joao",46,"joao@gmail.com",idContaCorrente01,true);
		Cliente cliente2 = new Cliente(idCliente02,"Maria",11,"maria@gmail.com",idContaCorrente02,true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientes);
		
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		assertTrue(clienteRemovido);
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
	
}
