/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data: 26/05/2018
 *---------------------------------------------
 * Descri��o: Interface para reposit�rio de 
 * 			  funcion�rio.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package interfaces;

import java.sql.ResultSet;

import entidades.Funcionario;
import excecoes.CPFNaoEncontradoException;

public interface IRepositorioFuncionario {
	public void inserir(Funcionario produto);
	public Funcionario procurar(String identificador) throws CPFNaoEncontradoException;
	public void remover(String identificador);
	public void atualizar(Funcionario produto);
	public ResultSet listar();
	public ResultSet listar(String identificador);
}
