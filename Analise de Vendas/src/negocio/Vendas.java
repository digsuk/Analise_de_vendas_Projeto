/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *---------------------------------------------
 * Descrição: Classe de vendas
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package negocio;
import java.util.Date;
public class Vendas extends Produto{
	
	private String cpf, cnpj;
	private Date data; 
	public Vendas(String nome, String descricao, int quantidade, double valor, String porcentagem, String chave, String cpf, String cnpj, Date data) {
		super(nome, descricao, quantidade, valor, porcentagem, chave);
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.data = data;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}