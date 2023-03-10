package sistemabancario;

import static org.junit.Assert.assertThat;
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
		Cliente cliente1 = new Cliente(1,"Joao",46,"joao@gmail.com",1,true);
		Cliente cliente2 = new Cliente(2,"Maria",11,"maria@gmail.com",2,true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		
		gerClientes = new GerenciadoraClientes(clientes);
		
		//execucao do teste
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		//verificacao do resultado
		assertThat(cliente.getId(), is(1));
	}
	
}
