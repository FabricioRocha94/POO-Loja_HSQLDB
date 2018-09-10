package poo.loja.desconto;

import poo.loja.modelo.Venda;

public class DescontoValorAlto extends Desconto {
	
	public double getValor(Venda venda) {
		if(venda.calcularValorProdutos() > 5000) {
			return venda.calcularValorProdutos()*0.2;
		}
		return proximo.getValor(venda);
	}
	
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
