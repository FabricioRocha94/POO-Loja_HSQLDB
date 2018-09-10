package poo.loja;

import poo.loja.desconto.Desconto;
import poo.loja.desconto.DescontoGamer;
import poo.loja.desconto.DescontoGrandeQuantidade;
import poo.loja.desconto.DescontoProdutoValorAlto;
import poo.loja.desconto.DescontoValorAlto;
import poo.loja.desconto.DescontoVendaCasada;
import poo.loja.desconto.SemDesconto;
import poo.loja.imposto.ICMSSP;
import poo.loja.imposto.IGQ;
import poo.loja.imposto.IPL;
import poo.loja.modelo.Produto;
import poo.loja.modelo.Venda;

public class Loja {

	public static void main(String[] args) {
		Desconto d1 = new DescontoGamer();
		Desconto d2 = new DescontoValorAlto();
		Desconto d3 = new DescontoGrandeQuantidade();
		Desconto d4 = new DescontoProdutoValorAlto();
		Desconto d5 = new DescontoVendaCasada();
		Desconto d0 = new SemDesconto();
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		d4.setProximo(d5);
		d5.setProximo(d0);
		
		Venda venda = new Venda();
		
		Produto p1 = new Produto();
		p1.setNome("Desktop");
		p1.setValor(3100);
		venda.adicionarProduto(p1);
		Produto p2 = new Produto();
		p2.setNome("Monitor");
		p2.setValor(800);
		venda.adicionarProduto(p2);
		venda.setImposto(new ICMSSP(new IPL(new IGQ())));
		venda.setDesconto(d1);
		System.out.println(venda);
		

	}

}





