/*------------------------------------------------
 * Autor: Diogo Souza
 * Data:04/05/2018
 *------------------------------------------------
 * Descrição: Telas Assistentes: Para confirma-
 *  ções e entre outros;
 *------------------------------------------------
 * Histórico de modificação
 * Data             Autor                   Descrição
 * 09/05/2018 |  Diogo Souza      | Adição do método confirmar exclusão;
 *----------------------------------------------------------------------*/

package telas;

import javax.swing.JOptionPane;

public class TelasAssistentes {
	
	private static int confirm;

	public static void ConfirmarCadastro() {
		
		confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja cadastrar?", "Cadastrado", JOptionPane.YES_NO_OPTION);
	}
	
	public static void ConfirmarExclusao() {
		confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir?", "Excluído", JOptionPane.YES_NO_OPTION);
	}
	
	public static void ConfirmarBusca() {
		confirm = JOptionPane.showConfirmDialog(null, "Confirma os dados para busca?", "Busca Concluída", JOptionPane.YES_NO_OPTION);
	}
	
	public static void ConfirmarEdicaoDados() {
		confirm = JOptionPane.showConfirmDialog(null, "Confirma os dados?", "Edição Concluída", JOptionPane.YES_NO_OPTION);
	}
	
	public static void ConfirmarProduto() {
		confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja cadastrar o produto?", "Cadastrado", JOptionPane.YES_NO_OPTION);
	}
	
	public static void ConfirmarDistribuicao() {
		confirm = JOptionPane.showConfirmDialog(null, "Confirma a distribuição?", "Distrubuído", JOptionPane.YES_NO_OPTION);
	}

}