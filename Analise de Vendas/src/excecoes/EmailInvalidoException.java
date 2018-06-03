/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descri��o: Exce��o para email inv�lido.
 * 
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/

package excecoes;

import negocio.Mensagem;

public class EmailInvalidoException extends Exception{
	public String getMessage(){
		return Mensagem.EMAILINVALIDO;
	}
}