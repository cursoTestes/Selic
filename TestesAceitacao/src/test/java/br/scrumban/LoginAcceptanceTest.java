package br.scrumban;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.scrumban.infraestrutura.BaseAcceptanceTest;

public class LoginAcceptanceTest extends BaseAcceptanceTest {

	@Test
	public void teste_login_com_sucesso_gera_entrada_na_tabela_sucessoLogin() {
		Integer entradasEsperadasNaTabela = 1 ;
		String texto_mensagem_logado_com_sucesso = "Welcome, cfc!";
		
		//act
		driver.get("http://localhost:8080/AceitacaoComJava/login.seam");
		
		driver.findElement(By.id("loginForm:username")).sendKeys("cfc");
		driver.findElement(By.id("loginForm:password")).sendKeys("123456");
		driver.findElement(By.id("loginForm:submit")).click();
      
		WebElement element = driver.findElement(By.xpath("id('messages')/li[2]"));
		System.out.println("> >>>>>>>>>>>> " + element.getText() );
		 
		boolean acheiTextoLogadoSucesso = element.getText().equals(texto_mensagem_logado_com_sucesso);
		Assert.assertTrue(acheiTextoLogadoSucesso);
		
		Integer resultadoEntradasSucessoLog = (Integer)emf.createEntityManager().createNativeQuery("select count(*) from SucessoLogin").getSingleResult();
		Assert.assertEquals(entradasEsperadasNaTabela,resultadoEntradasSucessoLog);
		
	}
	
	@Test
	public void teste_login_inexistente_sem_gerar_entrada_na_tabela_falhaLogin() {
		Integer entradasEsperadasNaTabela = 0 ;
		String texto_mensagem_login_sem_sucesso = "Login failed";
		
		//act
		driver.get("http://localhost:8080/AceitacaoComJava/login.seam");
		
		driver.findElement(By.id("loginForm:username")).sendKeys("");
		driver.findElement(By.id("loginForm:password")).sendKeys("");
		driver.findElement(By.id("loginForm:submit")).click();
      
		WebElement element = driver.findElement(By.xpath("id('messages')/li[1]"));
		System.out.println("> >>>>>>>>>>>> " + element.getText() );
		 
		boolean acheiTextoLogadoSucesso = element.getText().equals(texto_mensagem_login_sem_sucesso);
		Assert.assertTrue(acheiTextoLogadoSucesso);
		
		Integer resultadoEntradasErroLog = (Integer)emf.createEntityManager().createNativeQuery("select count(*) from FalhaLogin").getSingleResult();
		Assert.assertEquals(entradasEsperadasNaTabela,resultadoEntradasErroLog);
		
	}

	@Test
	public void teste_login_com_erro_gera_entrada_na_tabela_erroLogin() {
		Integer entradasEsperadasNaTabelaErro = 1 ;
		Integer entradasEsperadasNaTabelaSucesso = 0 ;
		String texto_mensagem_logado_com_erro = "Login failed";
		
		//act
		driver.get("http://localhost:8080/AceitacaoComJava/login.seam");
		
		driver.findElement(By.id("loginForm:username")).sendKeys("cfc");
		driver.findElement(By.id("loginForm:password")).sendKeys("133456");
		driver.findElement(By.id("loginForm:submit")).click();
      
		WebElement element = driver.findElement(By.xpath("id('messages')/li[2]"));
		System.out.println("> >>>>>>>>>>>> " + element.getText() );
		 
		boolean acheiTextoLogadoSucesso = element.getText().equals(texto_mensagem_logado_com_erro);
		Assert.assertEquals(texto_mensagem_logado_com_erro, element.getText());
		
		Integer resultadoEntradasErroLog = (Integer)emf.createEntityManager().createNativeQuery("select count(*) from falhaLogin").getSingleResult();
		Integer resultadoEntradasSucessoLog = (Integer)emf.createEntityManager().createNativeQuery("select count(*) from sucessoLogin").getSingleResult();
		Assert.assertEquals(entradasEsperadasNaTabelaErro,resultadoEntradasErroLog);
		Assert.assertEquals(entradasEsperadasNaTabelaSucesso,resultadoEntradasSucessoLog);
		
	}
}
