package br.scrumban;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("");
		fill("#Valor").with("");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor é obrigatório.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda é obrigatório.", findFirst("#validacaoDataVenda").getText());
			
	}
	
	@Test
	public void teste_cadastra_uma_venda_campos_preenchidos_com_sucesso() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("12");
		fill("#DataVenda").with("12/12/2012");
		fill("#Valor").with("100");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Venda incluída com sucesso.", findFirst("#mensagem").getText());
			
	}

	@Test
	public void teste_cadastra_uma_venda_data_invalida() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("111");
		fill("#DataVenda").with("30/13/2012");
		fill("#Valor").with("100.00");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Data inválida.", findFirst("#validacaoDataVenda").getText());
			
	}
		
	}
