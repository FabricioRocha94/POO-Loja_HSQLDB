package poo.loja.imposto;

import poo.loja.modelo.Venda;

public class IGQ extends TemplateImposto {
	
	public IGQ(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}
	
	public IGQ() {
		super();
	}
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		return (venda.quantidadeProdutos() > 5);
	}

	@Override
	protected double taxaMaxima() {
		return 0.2;
	}

	@Override
	protected double taxaNormal() {
		return 0.05;
	}

}
