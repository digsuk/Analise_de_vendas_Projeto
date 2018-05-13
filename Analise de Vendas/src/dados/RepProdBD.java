/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:03/05/2018
 *---------------------------------------------
 * Descrição: Repositorio banco de dados
 *  para produtos.
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;

import negocio.Objetos;
import negocio.Produto;

public class RepProdBD extends RepositorioBD{
	private Connection con;
	public RepProdBD(){
		super();
	}
	public void atualizar(Produto produto, String comando) {
		try {
			PreparedStatement pstm = con.prepareStatement(comando);
			pstm.setString(2, produto.getNome());
			pstm.setString(1, produto.getDescricao());
			pstm.setInt(3, produto.getQuantidade());
			pstm.setDouble(3, produto.getValor());
			pstm.setString(5, produto.getPorcentagem());
			pstm.setString(6, produto.getChave());
			int res = pstm.executeUpdate(comando);
			if (res > 0) {
				System.out.println("Sucesso!");
			} else {
				System.err.println("Erro!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}