package poo.loja.imposto;

import poo.loja.modelo.Venda;

public abstract class TemplateImposto implements Imposto {
	
	protected Imposto outroImposto;
	
	public TemplateImposto() {
		outroImposto = new SemImposto();
	}
	
	public final double getValor(Venda venda) {
		if(isTaxaMaxima(venda)) {
			return venda.calcularValorProdutos()*taxaMaxima() + outroImposto.getValor(venda);
		} else {
			return venda.calcularValorProdutos()*taxaNormal() + outroImposto.getValor(venda);
		}
	}

	protected abstract boolean isTaxaMaxima(Venda venda);
	
	protected abstract double taxaMaxima();
	
	protected abstract double taxaNormal();
	
}
