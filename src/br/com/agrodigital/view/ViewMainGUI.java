package br.com.agrodigital.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ViewMainGUI {

	private JFrame frmAgroDigital;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMainGUI window = new ViewMainGUI();
					window.frmAgroDigital.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgroDigital = new JFrame();
		frmAgroDigital.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmAgroDigital.setTitle("Agro Digital");
		frmAgroDigital.setBounds(100, 100, 958, 504);
		frmAgroDigital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgroDigital.getContentPane().setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		frmAgroDigital.setJMenuBar(menuBar);
		
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem menuItemLogin = new JMenuItem("Login");
		menuItemLogin.setEnabled(false);
		menuArquivo.add(menuItemLogin);	

		
		JMenuItem menuItemFechar = new JMenuItem("Fechar");
		menuArquivo.add(menuItemFechar);	
		menuItemFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
			
		JMenu menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);

		JMenuItem menuItemPropriedade = new JMenuItem("Propriedade");
		menuItemPropriedade.setEnabled(false);
		menuCadastro.add(menuItemPropriedade);
		menuItemPropriedade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPropriedade view = new ViewPropriedade();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		
		
		JMenuItem menuItemLancamento = new JMenuItem("Lançamentos");
		menuCadastro.add(menuItemLancamento);
		menuItemLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLancamento view = new ViewLancamento();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		
		JMenuItem menuItemConta = new JMenuItem("Conta");
		menuCadastro.add(menuItemConta);
		menuItemConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConta view = new ViewConta();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
			
		JMenuItem menuItemUsuario = new JMenuItem("Usuario");
		menuItemUsuario.setEnabled(false);
		menuCadastro.add(menuItemUsuario);
		menuItemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewUsuario view = new ViewUsuario();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		
		JMenu menuRelatorio = new JMenu("Relatório");
		menuBar.add(menuRelatorio);
		
		JMenuItem menuItemRelatorio = new JMenuItem("Relatório");
		menuRelatorio.add(menuItemRelatorio);
		menuItemRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRelatorio view = new ViewRelatorio();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		
	
	}
	
}
