package poo.loja.imposto;

import poo.loja.modelo.Venda;

public class ISJ extends TemplateImposto {
	
	public ISJ(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}
	
	public ISJ() {
		super();
	}
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		// TODO Auto-generated method stub
		return (venda.temProduto("Gamer"));
	}

	@Override
	protected double taxaMaxima() {
		// TODO Auto-generated method stub
		return 0.15;
	}

	@Override
	protected double taxaNormal() {
		// TODO Auto-generated method stub
		return 0.03;
	}

}
