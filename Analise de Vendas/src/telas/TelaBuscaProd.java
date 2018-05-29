/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:13/05/2018
 *---------------------------------------------
 * Descrição: Classe de tela da busca de 
 * 			  produtos.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.ClasseAssistente;
import negocio.Fachada;
import negocio.ModeloTabelaProduto;
import negocio.Produto;
import negocio.ValidarDados;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaBuscaProd extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTable table;
	private ModeloTabelaProduto modelo; 
	JScrollPane scrollPane;
	public static TelaBuscaProd instance;
	JButton btnRemover;
	JButton btnEditar; 
	
	public static TelaBuscaProd getInstance() {
		if (instance == null)
			instance = new TelaBuscaProd();
		return instance;
	}
	
	public void limparCampos(){
		textFieldNome.setText("");
		if(table.getRowCount() > 0)
			table.removeRowSelectionInterval(0, table.getRowCount() - 1);
	}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscaProd frame = new TelaBuscaProd();
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
	public TelaBuscaProd() {
		setTitle("An\u00E1lise de Vendas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 135, 594, 487);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(90, 30, 86, 21);
		panel.add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(150, 31, 203, 20);
		panel.add(textFieldNome);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(modelo.getRowCount()>0)
					modelo.removeProdutoAt(0);
				if (textFieldNome.getText().equals("")) {
					ResultSet rs;
					rs = Fachada.getInstance().listarProd();
					ClasseAssistente.montarTabelaProduto(rs, modelo);
				} else{
					Produto produto;
					produto = Fachada.getInstance().procurarProd(textFieldNome.getText());
					ClasseAssistente.montarTabelaProduto(produto, modelo, table);
				}
				scrollPane.setVisible(true);
				btnEditar.setVisible(true);
				btnRemover.setVisible(true);
			}
		});
		btnBuscar.setBounds(383, 31, 89, 23);
		panel.add(btnBuscar);
		
		modelo = new ModeloTabelaProduto();
		table = new JTable(modelo);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBounds(68, 163, 100, 30);
		table.setPreferredScrollableViewportSize(new Dimension(500,100));
		table.setFillsViewportHeight(true);

		scrollPane=new JScrollPane(table);
		scrollPane.setBounds(20, 118, 452, 157);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setBounds(20, 76, 173, 14);
		panel.add(lblResultado);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 93, 574, 14);
		panel.add(separator);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto produto;
				int[] linhas = table.getSelectedRows(); 
				if(linhas.length>0){
					for(int i = 0; i < linhas.length; i++){
						produto = modelo.removeProdutoAt(i);
						Fachada.getInstance().removerProd(produto.getNome());
					}
				}else{
					Popup.selectRow();
				}
			}
		});
		btnRemover.setBounds(484, 121, 89, 23);
		panel.add(btnRemover);
		btnRemover.setVisible(false);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto;
				int[] linhas = table.getSelectedRows();
				if(linhas.length == 1){
					TelaEditProd.getInstance().passProduto(modelo.getProdutoAt(linhas[0]));
					TelaEditProd.getInstance().setVisible(true);
					TelaBuscaProd.getInstance().setVisible(false);
				}else{
					Popup.select1Row();
				}
			}
		});
		btnEditar.setBounds(484, 166, 89, 23);
		panel.add(btnEditar);
		
		JLabel lblDistribuir = new JLabel("Distribuir:");
		lblDistribuir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDistribuir.setBounds(20, 305, 173, 14);
		panel.add(lblDistribuir);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 322, 574, 14);
		panel.add(separator_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 349, 366, 21);
		panel.add(comboBox);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVendedor.setBounds(20, 347, 86, 21);
		panel.add(lblVendedor);
		
		JButton btnDistribuir = new JButton("Distribuir");
		btnDistribuir.setBounds(479, 348, 89, 23);
		panel.add(btnDistribuir);
		btnEditar.setVisible(false);
		
		JLabel lblBuscaDeProduto = new JLabel("Gerenciamento de produto");
		lblBuscaDeProduto.setForeground(SystemColor.window);
		lblBuscaDeProduto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBuscaDeProduto.setBounds(26, 99, 234, 25);
		contentPane.add(lblBuscaDeProduto);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Produto");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Cadastrar");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadProd.getInstance().setVisible(true);
				limparCampos();
				scrollPane.setVisible(false);
				dispose();
			}
		});
		menu.add(menuItem);
		
		JMenuItem mntmGerenciar = new JMenuItem("Gerenciar");
		menu.add(mntmGerenciar);
		
		JMenu menu_1 = new JMenu("Vendedor");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("Cadastrar");
		menu_1.add(menuItem_3);
		
		JMenuItem mntmGerenciar_1 = new JMenuItem("Gerenciar");
		menu_1.add(mntmGerenciar_1);
		
		JMenu menu_2 = new JMenu("Vendas");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("Relat\u00F3rio");
		menu_2.add(menuItem_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(26, 60, 152, 23);
		contentPane.add(panel_1);
		
		JButton button = new JButton(" Informa\u00E7\u00F5es de ajuda");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setIcon(new ImageIcon(TelaBuscaProd.class.getResource("/imagem/question.png")));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(0, 0, 152, 23);
		panel_1.add(button);
	}
}
