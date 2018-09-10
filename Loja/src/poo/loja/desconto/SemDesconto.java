package poo.loja.desconto;

import poo.loja.modelo.Venda;

public class SemDesconto extends Desconto {
	
	public double getValor(Venda venda) {
		return 0;
	}
	
	public void setProximo(Desconto proximo) {
		
	}

}
