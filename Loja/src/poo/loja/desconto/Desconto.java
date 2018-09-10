package poo.loja.desconto;

import poo.loja.modelo.Venda;

public abstract class Desconto {
	
	protected Desconto proximo;
	
	public abstract double getValor(Venda venda);
	public abstract void setProximo(Desconto proximo);

}
