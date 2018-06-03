/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descri��o: Exce��o para senha inv�lida.
 * 
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/

package excecoes;

import negocio.Mensagem;

public class SenhaInvalidaException extends Exception{
	public String getMessage(){
		return Mensagem.SENHAINVALIDA;
	}
}
