/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe fachada para cadastro
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    		Autor 		   Descrição
 * 14/05/18 |Jonathan Moura | CRUD funcionário
 *-------------------------------------------*/
package negocio;
import java.sql.ResultSet;

import dados.*;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioFuncionario;
import interfaces.IRepositorioProduto;
public class Fachada {
	private static Fachada instance;
	private CadastroProduto produto;
	private CadastroFuncionario funcionario;
	public Fachada(){
		IRepositorioProduto repProd = new RepProdArray();
		IRepositorioFuncionario repFunc = new RepFuncArray();
		
		produto = new CadastroProduto(repProd);
		funcionario = new CadastroFuncionario(repFunc);
	}
	
	public static Fachada getInstance(){
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
	public Produto procurarProd(String identificador){
		return (Produto) produto.procurar(identificador);
	}
	public void removerProd(String identificador)  {
		produto.remover(identificador);
	}	
	public void atualizar(Produto produto)  {
		this.produto.atualizar(produto);
	}
	public ResultSet listarProd(){
		return this.produto.listar();
	}
	//FIM CRUD de produto
	
	//INICIO CRUD de funcionário
	public void cadastrar(Funcionario funcionario){
		this.funcionario.inserir(funcionario);
	}
	public Funcionario procurarFunc(String identificador)throws CPFNaoEncontradoException{
		return (Funcionario) funcionario.procurar(identificador);
	}
	public void removerFunc(String identificador)  {
		funcionario.remover(identificador);
	}	
	public void atualizar(Funcionario funcionario)  {
		this.funcionario.atualizar(funcionario);
	}
	//FIM CRUD de funcionário
}