/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:30/04/2018
 *---------------------------------------------
 * Descrição: Repositorio banco de dados padrão
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package dados;
import negocio.Objetos;
import interfaces.IRepositorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RepositorioBD implements IRepositorio {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;

	public RepositorioBD() {
		url = "jdbc:postgresql://localhost:5432/postgres";
		usuario = "postgres";
		senha = "123456";

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserir(Objetos objeto, String comando) {
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(comando);
			if (res > 0) {
				System.out.println("Sucesso!");
			} else {
				System.err.println("Erro!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet procurar(String comando, String identificador) {
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs != null) {
				System.out.println("Sucesso!");
			} else {
				System.err.println("Erro!");
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void remover(String comando, String identificador) {
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(comando);
			if (res > 0) {
				System.out.println("Sucesso!");
			} else {
				System.err.println("Erro!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Objetos objeto, String comando) {
		try {
/*			Statement stm = con.createStatement();*/
			PreparedStatement pstm = con.prepareStatement(comando);
			
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
