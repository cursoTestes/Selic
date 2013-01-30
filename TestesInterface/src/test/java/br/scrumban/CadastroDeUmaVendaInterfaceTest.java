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
		
		Assert.assertEquals("O campo Id Vendedor � obrigat�rio.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor � obrigat�rio.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda � obrigat�rio.", findFirst("#validacaoDataVenda").getText());
			
	}
	
	@Test
	public void teste_cadastra_uma_venda_campos_preenchidos_com_sucesso() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("12");
		fill("#DataVenda").with("12/12/2012");
		fill("#Valor").with("100");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Venda inclu�da com sucesso.", findFirst("#mensagem").getText());
			
	}

	@Test
	public void teste_cadastra_uma_venda_data_invalida() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("111");
		fill("#DataVenda").with("30/13/2012");
		fill("#Valor").with("100.00");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Data inv�lida.", findFirst("#validacaoDataVenda").getText());
			
	}
		
	}
