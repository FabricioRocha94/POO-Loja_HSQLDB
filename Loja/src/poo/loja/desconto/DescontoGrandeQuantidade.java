package poo.loja.desconto;

import poo.loja.modelo.Venda;

public class DescontoGrandeQuantidade extends Desconto {

	public double getValor(Venda venda) {
		if(venda.quantidadeProdutos() > 5) {
			return venda.calcularValorProdutos()*0.1;
		}
		return proximo.getValor(venda);
	}
	
	public void setProximo(Desconto proximo) {
		this.proximo =  proximo;
	}
}
