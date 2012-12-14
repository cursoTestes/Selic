package br;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.mockito.Mockito;

import org.junit.Test;

import br.dao.VendaRepository;
import br.modelo.Venda;

public class CalculadoraRoyaltiesUnitTest {

	@Test
	public void test_Calcular_Royalties_Somente_Uma_Venda_De_100_Reais_Espera_20_Reais() {
		double entrada = 100;
		double esperado = 20;
		Date dataQualquer = new Date();

		VendaRepository mockVendaRepo = mock(VendaRepository.class);
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(1, 1, 1, 1, entrada);
		vendas.add(venda);

		when(mockVendaRepo.obterVendasPorMesEAno(any(Integer.class), any(Integer.class))).thenReturn(vendas);

		Calculadora mockCalculadoraComissao = mock(Calculadora.class);
		when(mockCalculadoraComissao.calcularComissao(any(Double.class))).thenReturn(0.0);
		
		CalculadoraRoyalties calculadora = new CalculadoraRoyalties(mockVendaRepo, mockCalculadoraComissao);
		
		double resultadoObtido = calculadora.calcularRoyalties(dataQualquer);
		
		assertEquals(esperado, resultadoObtido, 0);
		
		Mockito.verify(mockCalculadoraComissao).calcularComissao(any(Double.class));
		Mockito.verify(mockVendaRepo).obterVendasPorMesEAno(any(Integer.class), any(Integer.class));
		
		
	}

	@Test
	public void test_Calcular_Royalties_Somente_Uma_Venda_De_200_Reais_Espera_40_Reais() {
		double entrada = 200;
		double esperado = 40;
		Date dataQualquer = new Date();

		VendaRepository mockVendaRepo = mock(VendaRepository.class);
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(1, 1, 1, 1, entrada);
		vendas.add(venda);

		when(mockVendaRepo.obterVendasPorMesEAno(any(Integer.class), any(Integer.class))).thenReturn(vendas);

		Calculadora mockCalculadoraComissao = mock(Calculadora.class);
		when(mockCalculadoraComissao.calcularComissao(any(Double.class))).thenReturn(0.0);
		
		CalculadoraRoyalties calculadora = new CalculadoraRoyalties(mockVendaRepo, mockCalculadoraComissao);
		
		double resultadoObtido = calculadora.calcularRoyalties(dataQualquer);
		
		assertEquals(esperado, resultadoObtido, 0);

		Mockito.verify(mockCalculadoraComissao).calcularComissao(any(Double.class));
		Mockito.verify(mockVendaRepo).obterVendasPorMesEAno(any(Integer.class), any(Integer.class));

		
	}
}
