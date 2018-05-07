/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe de cadastro do produto 
 * 			  no repositorio BD ou Array.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package negocio;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorio;
public class CadastroProduto {
	private IRepositorio repositorio;
	private static final String INSERIR = "INSERT INTO produtos ";
	private static final String PROCURAR = "SELECT * FROM produtos ";
	private static final String REMOVER = "DELETE FROM produtos WHERE nome = ";
	private static final String ATUALIZAR = "UPDATE produtos SET nome = ?, descricao = ?, quantidade = ?, valor = ?, porcentagem = ?, chave = ? WHERE nome = ?";
	private static final String CAMPOS = "(id, nome, descricao, quantidade, valor, porcentagem, chave) ";	
	
	public CadastroProduto(IRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	/*Construir comando sql para inserir os valores 
	 *dos atributos do objeto no repositorio BD ou Array */
	public void inserir(Produto produto){
		String valores =  "values (default," + produto.getNome() + "," + produto.getDescricao() + "," + produto.getQuantidade()
		 				 + "," + produto.getValor() + "," + produto.getPorcentagem() + "," + produto.getChave() + ")";
		String comando = INSERIR + CAMPOS + valores;
		repositorio.inserir(produto, comando);
	}
	public Object procurar(String identificador) throws CPFNaoEncontradoException{
		if(identificador != null){
			String where = "WHERE nome = " + identificador;
			String comando = PROCURAR + where;
			return repositorio.procurar(comando, identificador);
		}else{
			return repositorio.procurar(PROCURAR, identificador);
		}
	}
	public void remover(String identificador){
		String comando = REMOVER + identificador;
		repositorio.remover(comando, identificador);
	}
	public void atualizar(Objetos objeto){
		repositorio.atualizar(objeto, ATUALIZAR);
	}
	
}
