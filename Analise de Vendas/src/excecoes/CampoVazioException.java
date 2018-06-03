/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descri��o: Classe de excecao para campos
 * 			  vazios.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package excecoes;

import negocio.Mensagem;

public class CampoVazioException extends Exception{
	public String getMessage(){
		return Mensagem.CAMPOVAZIO;
	}
}
