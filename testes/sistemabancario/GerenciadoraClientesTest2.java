package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest2 {
	
	/**
	 * Classe de teste para testar operacoes de {@link GerenciadoraClientes}
	 * 
	 *  @author Daniel Bastos
	 *  @date 10/03/2023
	 */
	
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	private int idContaCorrente01 =1;
	private int idContaCorrente02 =2;
	
	//Montagem do cenário global a cada execução de um teste
	@Before
	public void setUp() {
		Cliente cliente1 = new Cliente(1,"Joao",46,"joao@gmail.com",1,true);
		Cliente cliente2 = new Cliente(2,"Maria",11,"maria@gmail.com",2,true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientes);
	}
	
	//Desmontagem do cenário global a cada execução de um teste
	@After
	public void tearDown() {
		gerClientes.limpa();
	}

	@Test
	public void testPesquisaCliente() {
		//execucao do teste
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		//verificacao do resultado
		assertThat(cliente.getId(), is(idCliente01));
	}
	
	@Test
	public void testRemoveCliente() {
		
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		assertTrue(clienteRemovido);
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
	
}
