package poo.loja.desconto;

import poo.loja.modelo.Venda;

public class DescontoVendaCasada extends Desconto {

	@Override
	public double getValor(Venda venda) {
		if(venda.temProduto("Desktop") && venda.temProduto("Monitor")) {
			return venda.calcularValorProdutos()*0.03;
		}
		return proximo.getValor(venda);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
		
	}

}
