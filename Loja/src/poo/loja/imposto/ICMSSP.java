package poo.loja.imposto;

import poo.loja.modelo.Venda;

public class ICMSSP extends TemplateImposto {
	
	public ICMSSP(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}
	
	public ICMSSP() {
		super();
	}
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		return (venda.calcularValorProdutos() > 3000);
	}

	@Override
	protected double taxaMaxima() {
		return 0.3;
	}

	@Override
	protected double taxaNormal() {
		return 0.2;
	}
	
}
