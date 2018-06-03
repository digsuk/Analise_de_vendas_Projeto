/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *---------------------------------------------
 * Descri��o: Classe do vendedor
 * 
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/

package entidades;

public class Vendedor extends Funcionario{
	Produto[] produtos;
	
	public Vendedor(String nome, String cpf, String email, String senha, String funcao, String chave, Produto[] produtos) {
		super(nome, cpf, email, senha, funcao, chave);
		this.produtos = produtos;
	}

}