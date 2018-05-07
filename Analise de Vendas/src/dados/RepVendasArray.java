/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *---------------------------------------------
 * Descrição: Repositorio array para vendas
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package dados;
import negocio.Vendas;
public class RepVendasArray extends RepositorioArray{
	private Vendas[] repositorio;
	
	public RepVendasArray() {
		super();
		this.repositorio = new Vendas[TAMANHO];
	}
}