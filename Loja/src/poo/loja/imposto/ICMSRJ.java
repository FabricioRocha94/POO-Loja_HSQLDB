package poo.loja.imposto;

import poo.loja.modelo.Venda;

public class ICMSRJ extends TemplateImposto {
	
	public ICMSRJ(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}
	
	public ICMSRJ() {
		super();
	}
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		return (venda.calcularValorProdutos() > 2500);
	}

	@Override
	protected double taxaMaxima() {
		return 0.25;
	}

	@Override
	protected double taxaNormal() {
		return 0.15;
	}

}
