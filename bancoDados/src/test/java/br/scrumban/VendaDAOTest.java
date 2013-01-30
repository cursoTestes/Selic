package br.scrumban;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.scrumban.dao.VendaDAO;
import br.scrumban.dao.VendedorDAO;
import br.scrumban.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotal_Vendas_Vendedor_2_Em_2011_Retorno_100() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotal_Vendas_Vendedor_3_Em_2011_Retorno_500() {
		
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 500.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotal_Vendas_Vendedor_2_Em_2010_Retorno_200() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2010;
		double resultado;
		double esperado = 200.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotal_Vendas_Vendedor_2_Sem_Venda_No_Ano_2012_Retorna_0() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}

	@Test
	public void testTotal_Vendas_Vendedor_7_Em_2010_Retorno_200_Com_Venda_Compartilhada_De_400() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2010;
		double resultado;
		double esperado = 200.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotal_Vendas_Vendedor_7_Em_2011_Retorno_300_Com_Mais_De_Uma_Venda_Sendo_Uma_Compartilhada_De_400() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 300.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}

	@Test
	public void testTotal_Vendas_Vendedor_7_Em_2009_Retorno_300_Com_Venda_Compartilhada_Por_3_Vendedores() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2009;
		double resultado;
		double esperado = 300.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
}
