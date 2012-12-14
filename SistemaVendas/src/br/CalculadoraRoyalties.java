package br;

import java.util.Date;
import java.util.List;

import br.dao.VendaRepository;
import br.modelo.Venda;

public class CalculadoraRoyalties {
	
	private VendaRepository vendaRepository;
	
	private Calculadora calculadoraComissao;

	public CalculadoraRoyalties(VendaRepository vendaRepository,
			Calculadora calculadoraComissao) {
		
		this.calculadoraComissao = calculadoraComissao;
		this.vendaRepository = vendaRepository;
		
	}

	public double calcularRoyalties(Date dataQualquer) {
		List<Venda> vendas = vendaRepository.obterVendasPorMesEAno(dataQualquer.getMonth(), dataQualquer.getYear());
		double faturamento = 0;
		for (Venda venda : vendas) {
			double valor = venda.getValor();
			faturamento += valor - calculadoraComissao.calcularComissao(valor);
			
		}
				

		
		return faturamento *0.2;
	}

}
