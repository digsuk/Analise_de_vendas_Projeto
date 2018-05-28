/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:27/05/2018
 *---------------------------------------------
 * Descrição: Classe de tela da edição de 
 * 			  produtos.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Produto;
import javax.swing.JTextField;

public class TelaEditProd extends JFrame {

	private JPanel contentPane;
	private static TelaEditProd instance;
	public static Produto produto;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;
	
	public static TelaEditProd getInstance(Produto produto){
		if(instance == null)
			instance = new TelaEditProd(produto);
		return instance;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditProd frame = new TelaEditProd(produto);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaEditProd(Produto produto) {
		setTitle("An\u00E1lise de Vendas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(27, 60, 160, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInformaesDeAjuda = new JButton(" Informa\u00E7\u00F5es de ajuda");
		btnInformaesDeAjuda.setBounds(0, 0, 123, 23);
		panel_1.add(btnInformaesDeAjuda);
		btnInformaesDeAjuda.setForeground(Color.BLACK);
		btnInformaesDeAjuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInformaesDeAjuda.setBorderPainted(false);
		btnInformaesDeAjuda.setBorder(null);
		btnInformaesDeAjuda.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(130, 0, 25, 23);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(TelaBuscaProd.class.getResource("/imagem/ajuda.png")));
		JLabel lblEdicaoDeProduto = new JLabel("Edi\u00E7\u00E3o de produto");
		lblEdicaoDeProduto.setForeground(SystemColor.window);
		lblEdicaoDeProduto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEdicaoDeProduto.setBounds(26, 105, 173, 14);
		contentPane.add(lblEdicaoDeProduto);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 145, 594, 437);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(108, 73, 86, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(108, 117, 86, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Quantidade:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(108, 165, 86, 21);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Valor:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(108, 211, 86, 21);
		panel.add(label_3);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(326, 254, 89, 23);
		panel.add(btnEditar);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(204, 73, 140, 20);
		panel.add(textFieldNome);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(204, 117, 211, 20);
		panel.add(textFieldDescricao);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(204, 165, 86, 20);
		panel.add(textFieldQuantidade);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(204, 211, 86, 20);
		panel.add(textFieldValor);
		
		TelaEditProd.produto = produto;
		textFieldNome.setText(produto.getNome());
		textFieldDescricao.setText(produto.getDescricao());
		textFieldQuantidade.setText(String.valueOf(produto.getQuantidade()));
		textFieldValor.setText(String.valueOf(produto.getValor()));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(108, 254, 89, 23);
		panel.add(btnCancelar);
	}
}
