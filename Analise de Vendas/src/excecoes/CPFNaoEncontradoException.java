/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descri��o: Classe de exce��o para funcion�rio
 * 			  n�o encontrado.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package excecoes;

import negocio.Mensagem;

public class CPFNaoEncontradoException extends Exception{
	String cpf;
	
	public CPFNaoEncontradoException(String cpf){
		this.cpf = cpf;
	}
	public String getMessage(){
		return cpf + Mensagem.CPFNENCONTRADO;
	}
}