/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *---------------------------------------------
 * Descrição: Repositorio array para produtos
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package dados;

import negocio.Produto;

public class RepProdArray {
	public static final int TAMANHO = 1000000;
	private Produto[] repositorio;
	private int indice;
	private int i;

	public RepProdArray() {
		this.repositorio = new Produto[TAMANHO];
		indice = 0;
	}

	public int getIndice(String nome) {
		i = 0;
		if (indice != 0) {
			while (!nome.equals(repositorio[i].getNome())) {
				if (i > indice) {
					return -1;
				} else
					i++;
			}
			return i;
		}
		return -1;
	}

	public void inserir(Produto produto) {
		repositorio[indice] = produto;
		indice++;
	}

	public boolean existe(String nome) {
		i = getIndice(nome);
		if (i == -1)
			return false;
		else
			return true;
	}

	public Produto procurar(String nome) {
		if (!existe(nome)) {
			System.err.println("Erro!");
		}
		return this.repositorio[i];
	}

	public void remover(String nome) {
		if (!existe(nome)) {
			System.err.println("Erro!");
		}
		repositorio[i] = null;
		repositorio[i] = repositorio[indice - 1];
		repositorio[indice - 1] = null;
		indice--;
	}

	public void atualizar(Produto produto, String nome) {
		if (!existe(produto.getNome())) {
			System.err.println("Erro!");
		}
		repositorio[i] = produto;
	}
}
