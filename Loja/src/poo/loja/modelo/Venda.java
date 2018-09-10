package poo.loja.modelo;

import java.util.ArrayList;
import java.util.List;

import poo.loja.desconto.Desconto;
import poo.loja.imposto.Imposto;

public class Venda {
	
	private List<Produto> produtos;
	private Imposto imposto;
	private Desconto desconto;
	
	public Venda() {
		produtos = new ArrayList<Produto>();
	}
	
	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}
	
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public double calcularValorProdutos() {
		double total = 0;
		for (Produto produto : produtos) {
			total = total + produto.getValor();
		}
		return total;
	}
	
	public double calcularImposto() {
		return imposto.getValor(this);
	}
	
	public double calcularDesconto() {
		return desconto.getValor(this);
	}
	
	public double calcularValorTotal() {
		return calcularValorProdutos() + calcularImposto() - calcularDesconto();
	}
	
	public int quantidadeProdutos() {
		return produtos.size();
	}
	
	public boolean temProduto(String nome) {
		for (Produto produto : produtos) {
			if(produto.getNome().contains(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean produtoValorMaior(double valor) {
		for (Produto produto : produtos) {
			if(produto.getValor() > valor) {
				return true;
			}
		}
		return false;		
	}
	
	public String toString() {
		return "Valor dos produtos: " + calcularValorProdutos() +
				"\nValor do imposto: " + calcularImposto() +
				"\nValor do desconto: " + calcularDesconto() +
				"\nValor total: " + calcularValorTotal();
	}

}









