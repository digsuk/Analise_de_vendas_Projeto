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
public class RepProdArray extends RepositorioArray {
	private Produto[] repositorio;
	
	public RepProdArray() {
		super();
		this.repositorio = new Produto[TAMANHO];
	}
}