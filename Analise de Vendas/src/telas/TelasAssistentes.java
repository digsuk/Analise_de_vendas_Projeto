/*------------------------------------------------
 * Autor: Diogo Souza
 * Data:04/05/2018
 *------------------------------------------------
 * Descrição: Telas Assistentes: Para confirma-
 *  ções e entre outros;
 *------------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *----------------------------------------------*/

package telas;

import javax.swing.JOptionPane;

public class TelasAssistentes {
	
	private static int confirm;
	
	public TelasAssistentes(int confirm) {
		super();
		TelasAssistentes.confirm = confirm;
	}
    
	public int getConfirm() {
		return confirm;
	}


	public void setConfirm(int confirm) {
		TelasAssistentes.confirm = confirm;
	}


	public static void ConfirmarCadastro() {
		
		confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja cadastrar?", "Cadastrado", JOptionPane.YES_NO_OPTION);
	}
	

}