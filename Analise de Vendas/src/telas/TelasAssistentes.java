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
 * 26/05/2018 |  Jonathan Moura   | Adição do método numberFormat e 
 * 									constantes MSGALERT e MSGERROR.
 *----------------------------------------------------------------------*/

package telas;

import javax.swing.JOptionPane;

import excecoes.CPFNaoEncontradoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.SenhaInvalidaException;
import negocio.Mensagem;

public class TelasAssistentes {
	private static final String MSGALERT = "Mensagem de alerta";
	private static final String MSGERROR = "Mensagem de erro";
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
	
	public static void numberFormat(){
		JOptionPane.showMessageDialog(null, Mensagem.NUMBERFORMAT,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	
	public static void campoVazio(CampoVazioException cve){
		JOptionPane.showMessageDialog(null, cve.getMessage(),MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	
	public static void cpfNaoEncontrado(CPFNaoEncontradoException cpfnee){
		JOptionPane.showMessageDialog(null, cpfnee.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
	}
	
	public static void senhaInvalida(SenhaInvalidaException sie){
		JOptionPane.showMessageDialog(null, sie.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
	}
	
	public static void emailInvalido(EmailInvalidoException eie){
		JOptionPane.showMessageDialog(null, eie.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
	}
}