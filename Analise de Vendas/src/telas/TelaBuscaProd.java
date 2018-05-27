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
import negocio.Produto;
import negocio.ValidarDados;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaBuscaProd extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTable table;
	JScrollPane scrollPane;
	public static TelaBuscaProd instance;
	
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
	
	public void montarTabela(ResultSet rs) {
		int linhas,i = 0;
		try{
			if(table.getRowCount() > 0)
				table.removeRowSelectionInterval(0, table.getRowCount() - 1);
			while(rs.next()){
				table.setValueAt(false, i, 0);;
				table.setValueAt(rs.getString("nome"), i, 1);
				table.setValueAt(rs.getString("descrição"), i, 2);
				table.setValueAt(rs.getInt("quantidade"), i, 3);
				table.setValueAt(rs.getDouble("valor"), i, 4);	
				i++;
			}
		}catch(SQLException sqle){
			
		}
	}
	
	public void montarTabela(Produto produto){
		if(table.getRowCount() > 0)
			table.removeRowSelectionInterval(0, table.getRowCount() - 1);
		if(produto != null){
			table.setValueAt(false, 0, 0);
			table.setValueAt(produto.getNome(), 0, 1);
			table.setValueAt(produto.getDescricao(), 0, 2);
			table.setValueAt(produto.getQuantidade(), 0, 3);
			table.setValueAt(produto.getValor(), 0, 4); 
		}
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 135, 594, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(90, 30, 86, 21);
		panel.add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(150, 31, 140, 20);
		panel.add(textFieldNome);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().equals("")) {
					ResultSet rs;
					rs = Fachada.getInstance().listarProd();
					montarTabela(rs);
				} else{
					Produto produto;
					produto = Fachada.getInstance().procurarProd(textFieldNome.getText());
					montarTabela(produto);
				}
				scrollPane.setVisible(true);
			}
		});
		btnBuscar.setBounds(349, 28, 89, 23);
		panel.add(btnBuscar);
				
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", "", "", ""},
			},
			new String[] {
				"Selecionar", "Nome", "Descri\u00E7\u00E3o", "Quantidade", "Valor"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(68, 163, 100, 30);
		table.setPreferredScrollableViewportSize(new Dimension(500,100));
		table.setFillsViewportHeight(true);

		scrollPane=new JScrollPane(table);
		scrollPane.setBounds(59, 118, 449, 100);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setBounds(20, 76, 173, 14);
		panel.add(lblResultado);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 93, 574, 14);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Busca de produto");
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(26, 105, 173, 14);
		contentPane.add(lblNewLabel_1);
		
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
				scrollPane.setVisible(false);;
				dispose();
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Buscar");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Distribuir");
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("Vendedor");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("Cadastrar");
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Buscar");
		menu_1.add(menuItem_4);
		
		JMenu menu_2 = new JMenu("Vendas");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("Relat\u00F3rio");
		menu_2.add(menuItem_5);
	}
}
