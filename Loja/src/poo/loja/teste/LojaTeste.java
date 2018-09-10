package poo.loja.teste;

import java.util.Scanner;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

public class LojaTeste {
	
	public static void main(String[] args) {
		ProdutoDAO pDAO = new ProdutoDAO();
		String linha = "";
		int opcao = 0;
		while(opcao == 0) {
			System.out.println("1 - Adicionar \n2 - Remover \n3 - Atualizar \n4 - Pesquisar por nome \n5 - Pesquisar por preço \n");
			System.out.println("Digite a opção desejada: ");
			Scanner ler = new Scanner(System.in);
			opcao = ler.nextInt();
			
			switch (opcao) {
			case 1:
				Produto p = new Produto();
				System.out.println("Digite o id do produto: ");
				p.setId(ler.nextInt());
				System.out.println("Digite o nome do produto: ");
				p.setNome(ler.next());
				System.out.println("Digite o valor do produto: ");
				p.setValor(ler.nextDouble());
				pDAO.insere(p);
				System.out.println("Produto adicionado com sucesso.");
				linha = ler.next();
				opcao = 0;
				break;
			case 2:
				System.out.println("Digite o id do produto a ser removido: ");
				int idR = ler.nextInt();
				pDAO.remover(idR);
				System.out.println("Produto removido com sucesso.");
				linha = ler.next();
				opcao = 0;
				break;
			case 3:
				System.out.println("Digite o id do produto que deseja atualizar: ");
				int idA = ler.nextInt();
				Produto pA = new Produto();
				pA.setId(idA);
				System.out.println("Digite o novo nome do produto: ");
				pA.setNome(ler.next());
				System.out.println("Digite o novo preço do produto: ");
				pA.setValor(ler.nextDouble());
				pDAO.atualizar(pA);
				System.out.println("Produto atualizado com sucesso.");
				linha = ler.next();
				opcao = 0;
				break;
			case 4:
				System.out.println("Digite o nome/parte do nome a ser pesquisado: ");
				String nomeP = ler.next();
				
				for(Produto prod : pDAO.pesquisar(nomeP)) {
					System.out.println(prod.getNome());
				}
				linha = ler.next();
				opcao = 0;
				break;
			case 5:
				System.out.println("Deseja pesquisar valores maior que o informado (Opção 1) ou menor que o informado (Opção 2)? ");
				opcao = ler.nextInt();
				System.out.println("Digite o valor de referência: ");
				double valor = ler.nextDouble();
				if (opcao == 1) {
					System.out.println("Valores maior que " + valor + ":");
					for(Produto prod : pDAO.pesquisar(valor, true)) {
						System.out.println(prod.getNome() + " - Valor: " + prod.getValor());
					}
				} else {
					System.out.println("Valores menor que " + valor + ":");
					for(Produto prod : pDAO.pesquisar(valor, false)) {
						System.out.println(prod.getNome() + " - Valor: " + prod.getValor());
					}
				}
				linha = ler.next();
				opcao = 0;
				break;
			}
		}
	}
}
