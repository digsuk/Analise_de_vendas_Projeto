/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe fachada para cadastro
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package negocio;
import dados.*;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorio;
public class Fachada {
	private static Fachada instance;
	private CadastroProduto produto;
	public Fachada(){
		IRepositorio repProd = new RepProdArray();
		
		produto = new CadastroProduto(repProd);
	}
	
	public Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
			return instance;
		}
		return instance;
	}
	//INICIO CRUD de produto
	public void cadastrar(Produto produto){
		this.produto.inserir(produto);
	}
	public Object procurar(String identificador)throws CPFNaoEncontradoException{
		return produto.procurar(identificador);
	}
	public void remover(String identificador)  {
		produto.remover(identificador);
	}	
	public void atualizar(Produto produto)  {
		this.produto.atualizar(produto);
	}
	//FIM CRUD de produto
}