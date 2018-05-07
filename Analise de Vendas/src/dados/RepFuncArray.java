/*------------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *------------------------------------------------
 * Descrição: Repositorio array para funcionários
 * 
 *------------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *----------------------------------------------*/
package dados;
import negocio.Funcionario;
public class RepFuncArray extends RepositorioArray{
	private Funcionario[] repositorio;
	
	public RepFuncArray() {
		super();
		this.repositorio = new Funcionario[TAMANHO];
	}
}
