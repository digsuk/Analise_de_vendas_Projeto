/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:30/04/2018
 *---------------------------------------------
 * Descri��o: Repositorio banco de dados padr�o
 * 
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package dados;

import java.sql.Connection;
import java.sql.DriverManager;

public class RepositorioBD {
	private String url;
	private String usuario;
	private String senha;
	protected static Connection con;

	public RepositorioBD() {
/*		url = "jdbc:postgresql://localhost:5432/postgres";
		usuario = "postgres";
		senha = "123456";
*/		url = "jdbc:postgresql://analise-de-vendas.cm0cizk23hog.sa-east-1.rds.amazonaws.com/analiseVendas";
		usuario = "JonathanMoura";
		senha = "123456789";
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conex�o realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}