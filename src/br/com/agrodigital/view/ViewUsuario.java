package br.com.agrodigital.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.EtchedBorder;

import br.com.agrodigital.model.Conta;
import br.com.agrodigital.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldSenha;
	private JTextField textFieldLogin;
	private String menuAtivo = "";
	

	
	/**
	 * Create the frame.
	 */
	public ViewUsuario() {
		setResizable(false);
		setTitle("Cadastrar Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Id");
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		textFieldSenha = new JPasswordField();
		textFieldSenha.setEnabled(false);
		textFieldSenha.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		textFieldLogin = new JTextField();
		textFieldLogin.setEnabled(false);
		textFieldLogin.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String idString;
				String login;
				String senha;
				
				switch (menuAtivo) {
				
				case "Adicionar":
					login = textFieldLogin.getText();
					senha = textFieldSenha.getText();
					
					Usuario usuarioAdicionar = new Usuario(login, senha);

					//Chamada do Controler
					
					JOptionPane.showMessageDialog(null, usuarioAdicionar.toString() + "\nincluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);				
					
					dispose();
					break;
					
				case "Listar":
					idString = textFieldId.getText();
					
					id = 0;
					try {
						id = Integer.parseInt(idString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID Inválido");
						return;
					}
					
					// Chamada do Controller
					
					/*	
					 
					*/
					break;
					
				case "Atualizar":
					idString = textFieldId.getText();
					login = textFieldLogin.getText();
					senha = textFieldSenha.getText();
					
					id = 0;
					try {
						id = Integer.parseInt(idString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID Inválido");
						return;
					}
					
					Usuario usuarioAtualizar = new Usuario(login, senha);

					// Chamada do Controller
					
					/*

					 */
					dispose();
					break;
					
				case "Deletar":
					idString = textFieldId.getText();
					
					id = 0;
					try {
						id = Integer.parseInt(idString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID Inválido");
						return;
					}
					
					//Chamada do Controller
					
					/*
					
					*/
					dispose();
					break;
					
				default:
					break;
				}
				textFieldId.setText("");
				textFieldLogin.setText("");
				textFieldSenha.setText("");
			}
		});
		btnConfirmar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnConfirmar.setPreferredSize(new Dimension(75, 23));
		btnConfirmar.setMinimumSize(new Dimension(75, 23));
		btnConfirmar.setMaximumSize(new Dimension(75, 23));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setIcon(null);
		btnCancelar.setForeground(Color.RED);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setPreferredSize(new Dimension(75, 23));
		btnAdicionar.setMinimumSize(new Dimension(75, 23));
		btnAdicionar.setMaximumSize(new Dimension(75, 23));
		btnAdicionar.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(0, 102, 0));
		btnListar.setPreferredSize(new Dimension(75, 23));
		btnListar.setMinimumSize(new Dimension(75, 23));
		btnListar.setMaximumSize(new Dimension(75, 23));
		btnListar.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.ORANGE);
		btnAtualizar.setPreferredSize(new Dimension(75, 23));
		btnAtualizar.setMinimumSize(new Dimension(75, 23));
		btnAtualizar.setMaximumSize(new Dimension(75, 23));
		btnAtualizar.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.RED);
		btnDeletar.setPreferredSize(new Dimension(75, 23));
		btnDeletar.setMinimumSize(new Dimension(75, 23));
		btnDeletar.setMaximumSize(new Dimension(75, 23));
		btnDeletar.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMenuAtivo("Adicionar");
				textFieldId.setEnabled(false);
				textFieldLogin.setEnabled(true);
				textFieldSenha.setEnabled(true);
				btnListar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnDeletar.setEnabled(false);
				btnConfirmar.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMenuAtivo("Listar");
				textFieldId.setEnabled(true);
				textFieldLogin.setEnabled(false);
				textFieldSenha.setEnabled(false);
				btnAdicionar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnDeletar.setEnabled(false);
				btnConfirmar.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMenuAtivo("Atualizar");
				textFieldId.setEnabled(true);
				textFieldLogin.setEnabled(true);
				textFieldSenha.setEnabled(true);
				btnAdicionar.setEnabled(false);
				btnListar.setEnabled(false);
				btnDeletar.setEnabled(false);
				btnConfirmar.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMenuAtivo("Deletar");
				textFieldId.setEnabled(true);
				textFieldLogin.setEnabled(false);
				textFieldSenha.setEnabled(false);
				btnAdicionar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnListar.setEnabled(false);
				btnConfirmar.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				textFieldId.setText("");
				textFieldLogin.setText("");
				textFieldSenha.setText("");
				textFieldId.setEnabled(false);
				textFieldLogin.setEnabled(false);
				textFieldSenha.setEnabled(false);
				btnAdicionar.setEnabled(true);
				btnListar.setEnabled(true);
				btnAtualizar.setEnabled(true);
				btnDeletar.setEnabled(true);
				btnConfirmar.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textFieldSenha, Alignment.LEADING)
										.addComponent(textFieldLogin, Alignment.LEADING)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
							.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
							.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(23))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addGap(2)
					.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldSenha, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(159))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnConfirmar, btnCancelar});
		contentPane.setLayout(gl_contentPane);
	}

	public String getMenuAtivo() {
		return menuAtivo;
	}

	public void setMenuAtivo(String menuAtivo) {
		this.menuAtivo = menuAtivo;
	}
}
