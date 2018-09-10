package poo.loja.imposto;

import poo.loja.modelo.Venda;

public class SemImposto implements Imposto {

	@Override
	public double getValor(Venda venda) {
		return 0;
	}
	
	

}
