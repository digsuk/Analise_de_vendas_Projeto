/*------------------------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *------------------------------------------------------------
 * Descrição: Repositorio array padrão
 * 
 *------------------------------------------------------------
 * Histórico de modificação
 * Data       Autor     Descrição
 * 01/05  | Jonathan | Adição de exceção ao método procurar.
 *------------------------------------------------------------*/
package dados;

import negocio.Objetos;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorio;

public class RepositorioArray implements IRepositorio {
	public static final int TAMANHO = 1000000;
	private Objetos[] repositorio;
	private int indice;
	private int i;

	public RepositorioArray() {
		this.repositorio = new Objetos[TAMANHO];
		indice = 0;
	}

	public int getIndice(String identificador) {
		i = 0;
		if (indice != 0) {
			while (!identificador.equals(repositorio[i].getNome())) {
				if (i > indice) {
					return -1;
				} else
					i++;
			}
			return i;
		}
		return -1;
	}

	public void inserir(Objetos objeto, String comando) {
		if (!existe(objeto.getNome())) {
			repositorio[indice] = objeto;
			indice++;
		}
	}

	public boolean existe(String identificador) {
		i = getIndice(identificador);
		if (i == -1)
			return false;
		else
			return true;
	}

	public Objetos procurar(String comando, String identificador) throws CPFNaoEncontradoException{
		if (!existe(identificador)) {
			CPFNaoEncontradoException cpfnee = new CPFNaoEncontradoException(identificador);
			throw cpfnee;
		}
		return this.repositorio[i];
	}

	public void remover(String comando, String identificador) {
		if (!existe(identificador)) {
			System.err.println("Erro!");
		}
		repositorio[i] = null;
		repositorio[i] = repositorio[indice - 1];
		repositorio[indice - 1] = null;
		indice--;
	}

	public void atualizar(Objetos objeto, String comando) {
		if (!existe(objeto.getNome())) {
			System.err.println("Erro!");
		}
		repositorio[i] = objeto;
	}
}
