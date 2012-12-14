package br;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraComissaoUnitTest {

	@Test
	public void test_Calcular_Comissao_Venda_100_Espera_5() {
		double valorVenda = 100;
		double valorEsperado = 5;
		
		Calculadora calculadora = new Calculadora();
		
		double valorRetornado = calculadora.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorRetornado, 0);
		
	}

	@Test
	public void test_Calcular_Comissao_Venda_200_Espera_10() {
		double valorVenda = 200;
		double valorEsperado = 10;
		
		Calculadora calculadora = new Calculadora();
		
		double valorRetornado = calculadora.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorRetornado, 0);
		
	}

	@Test
	public void test_Calcular_Comissao_Venda_20000_Espera_1200() {
		double valorVenda = 20000;
		double valorEsperado = 1200;
		
		Calculadora calculadora = new Calculadora();
		
		double valorRetornado = calculadora.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorRetornado, 0);
		
	}

	@Test
	public void test_Calcular_Comissao_No_Limite_Venda_10000_Espera_500() {
		double valorVenda = 10000;
		double valorEsperado = 500;
		
		Calculadora calculadora = new Calculadora();
		
		double valorRetornado = calculadora.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorRetornado, 0);
		
	}

	@Test
	public void test_Calcular_Comissao_No_Limite_Venda_10001_Espera_600_06() {
		double valorVenda = 10001;
		double valorEsperado = 600.06;
		
		Calculadora calculadora = new Calculadora();
		
		double valorRetornado = calculadora.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorRetornado, 0);
		
	}
	
	@Test
	public void test_Calcular_Comissao_Sem_Prejuizo_Venda_55_59_Espera_2_77() {
		double valorVenda = 55.59;
		double valorEsperado = 2.77;
		
		Calculadora calculadora = new Calculadora();
		
		double valorRetornado = calculadora.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorRetornado, 0);
		
	}

}
