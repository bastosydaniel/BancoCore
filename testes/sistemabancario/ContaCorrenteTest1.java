package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;


import java.util.ArrayList;
import java.util.List;

import javax.swing.event.DocumentListener;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

public class ContaCorrenteTest1 {
	/**
	 * Classe de teste para testar operacoes de {@link ContaCorrente}
	 * 
	 *  @author Daniel Bastos
	 *  @date 10/03/2023
	 */
	private GerenciadoraContas gerContas;
	
	private int idContaCorrente01 =1;
	private int idContaCorrente02 =2;
	

	@Before
	public void setUP() {
		// TODO Auto-generated method stub
		ContaCorrente conta01 = new ContaCorrente(idContaCorrente01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idContaCorrente02, 0, true);
		
		List<ContaCorrente>contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
	}
	
	@Test
	public void testTransfereValor() {
		double valorTransf = 50;
		
		double saldoc1 = gerContas.pesquisaConta(idContaCorrente01).getSaldo();
		double saldoc2 = gerContas.pesquisaConta(idContaCorrente02).getSaldo();
	
		boolean sucesso = gerContas.transfereValor(idContaCorrente01, valorTransf, idContaCorrente02);
		
		assertTrue(sucesso);
		assertThat(gerContas.pesquisaConta(idContaCorrente01).getSaldo(),is(saldoc1-valorTransf));
		assertThat(gerContas.pesquisaConta(idContaCorrente02).getSaldo(),is(saldoc2+valorTransf));
	}
	
}