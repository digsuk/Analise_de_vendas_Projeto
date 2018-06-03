/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *---------------------------------------------
 * Descri��o: Classe do funcion�rio
 * 
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package entidades;

public class Funcionario {
	private String nome, cpf, email, senha, funcao, chave;

	public Funcionario(String nome, String cpf, String email, String senha, String funcao, String chave) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.funcao = funcao;
		this.chave = chave;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}