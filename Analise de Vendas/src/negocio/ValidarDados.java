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

import excecoes.CPFNaoEncontradoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.SenhaInvalidaException;

public class ValidarDados {
	private static final String GERENTE = "Gerente";
	private static final String VENDEDOR = "Vendedor";
	private static final String MSGALERT = "Mensagem de alerta";
	private static final String MSGERROR = "Mensagem de erro";
	private static Funcionario funcionario;
	static Fachada fachada = new Fachada();
	public static boolean validarCampoVazio(String arg0, String arg1, String arg2, String arg3) {
		try {
			if (arg0.equals("") || arg1.equals("") || arg2.equals("") || arg3.equals("")) {
				CampoVazioException cve = new CampoVazioException();
				throw cve;
			}
		} catch (CampoVazioException cve) {
			JOptionPane.showMessageDialog(null, cve.getMessage(),MSGALERT,JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(null, cve.getMessage(),MSGALERT,JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean validarLogin(String cpf, String senha){
		try{
			funcionario = (Funcionario) fachada.procurar(cpf);
			if(!funcionario.getSenha().equals(senha)){
				SenhaInvalidaException sie = new SenhaInvalidaException();
				throw sie;
			}
		}catch(SenhaInvalidaException sie){
			JOptionPane.showMessageDialog(null, sie.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
			return false;
		}catch(CPFNaoEncontradoException cpfnee){
			JOptionPane.showMessageDialog(null, cpfnee.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static String identificaFuncao(){
		switch(funcionario.getFuncao()){
			case GERENTE: return GERENTE;
			case VENDEDOR: return VENDEDOR;
			default: return null;
		}
	}
	
	public static boolean validarEmail(String email){
		try{
			if(!email.matches("[\\w\\d]+@[^0-9]+(\\.com$|\\.br$)")){
				EmailInvalidoException eie = new EmailInvalidoException();
				throw eie;
			}
			
		}catch(EmailInvalidoException eie ){
			JOptionPane.showMessageDialog(null, eie.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
}
