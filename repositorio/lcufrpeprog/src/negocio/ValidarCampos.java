/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe de validação dos campos
 * 			  da tela de cadastro de produto
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package negocio;

import javax.swing.JOptionPane;
import excecoes.CampoVazioException;

public class ValidarCampos {
	static Fachada fachada = new Fachada();
	public static boolean validarCampoVazio(String arg0, String arg1, String arg2, String arg3) {
		try {
			if (arg0.equals("") || arg1.equals("") || arg2.equals("") || arg3.equals("")) {
				CampoVazioException cve = new CampoVazioException();
				throw cve;
			}
		} catch (CampoVazioException cve) {
			JOptionPane.showMessageDialog(null, cve.getMessage());
			return false;
		}
		return true;
	}

	public static boolean validarCampoVazio(String arg0, String arg1) {
		try {
			if (arg0.equals("") || arg1.equals("")) {
				CampoVazioException cve = new CampoVazioException();
				throw cve;
			}
		} catch (CampoVazioException cve) {
			JOptionPane.showMessageDialog(null, cve.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean validarLogin(String cpf, String senha){
		Funcionario funcionario;
		try{
			funcionario = (Funcionario) fachada.procurar(cpf);
			if(!funcionario.getSenha().equals(senha)){
				SenhaInvalidaException sie;
				throw sie;
			}
		}catch(SenhaInvalidaException sie){
			JOptionPane.showMessageDialog(null, sie.getMessage());
		}catch(FuncionarioNaoEncontradoException fnee){
			JOptionPane.showMessageDialog(null, fnee.getMessage());
		}
	}
}
