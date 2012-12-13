package br;

public class Calculadora {

	public double calcularComissao(double valorVenda) {
		double valorComissao;
		if (valorVenda <= 10000)
			valorComissao = valorVenda * 0.05;
		else
			valorComissao = valorVenda * 0.06;
		
		valorComissao = Math.floor(valorComissao * 100.0) / 100.0;
		
		return valorComissao;
	}
	
	

}
