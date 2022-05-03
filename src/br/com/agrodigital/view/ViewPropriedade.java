package br.com.agrodigital.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import br.com.agrodigital.controller.ControllerPropriedade;
import br.com.agrodigital.model.Propriedade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewPropriedade extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldMunicipio;
	private JTextField textFieldInscEst;
	private JTextField textFieldContato;
	private String menuAtivo = "";
	
	/**
	 * Create the frame.
	 */
	public ViewPropriedade() {
		setResizable(false);
		setTitle("Cadastrar Propriedade");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Id");
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		textFieldNome = new JTextField();
		textFieldNome.setEnabled(false);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Município");
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setEnabled(false);
		textFieldMunicipio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Inscrição Estadual");
		textFieldInscEst = new JTextField();
		textFieldInscEst.setEnabled(false);
		textFieldInscEst.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contato");
		textFieldContato = new JTextField();
		textFieldContato.setEnabled(false);
		textFieldContato.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String idString;
				String inscEst;
				String nome;
				String municipio;
				String contato;

				switch (menuAtivo) {
				
				case "Adicionar":
					inscEst = textFieldInscEst.getText();
					nome = textFieldNome.getText();
					municipio = textFieldMunicipio.getText();
					contato = textFieldContato.getText();
					
					Propriedade propriedadeAdicionar = new Propriedade(inscEst, nome, municipio, contato);

					boolean respostaAdicionar = ControllerPropriedade.getInstance().adicionar(propriedadeAdicionar);
					
					if(respostaAdicionar == true) {
						JOptionPane.showMessageDialog(null, propriedadeAdicionar.toString() + "\nincluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, propriedadeAdicionar.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					
					textFieldId.setText("");
					textFieldInscEst.setText("");
					textFieldNome.setText("");
					textFieldMunicipio.setText("");
					textFieldContato.setText("");
					
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
					
					Propriedade propriedadeListar = ControllerPropriedade.getInstance().listar(id);
					
					if (propriedadeListar != null) {
						textFieldInscEst.setText(String.valueOf(propriedadeListar.getInscEst()));
						textFieldNome.setText(propriedadeListar.getNome());
						textFieldMunicipio.setText(String.valueOf(propriedadeListar.getMunicipio()));
						textFieldContato.setText(propriedadeListar.getContato());
					}else {
						JOptionPane.showMessageDialog(null, "Propriedade: " + id + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
					}


					break;
					
				case "Atualizar":
					idString = textFieldId.getText();
					inscEst = textFieldInscEst.getText();
					nome = textFieldNome.getText();
					municipio = textFieldMunicipio.getText();
					contato = textFieldContato.getText();
					
					id = 0;
					try {
						id = Integer.parseInt(idString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID Inválido");
						return;
					}
					
					Propriedade propriedadeAtualizar = new Propriedade(id, inscEst, nome, municipio, contato);

					boolean respostaAtualizar = ControllerPropriedade.getInstance().atualizar(propriedadeAtualizar); 

					if(respostaAtualizar == true) {
						   JOptionPane.showMessageDialog(null, propriedadeAtualizar.toString() + "\nalterada com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, propriedadeAtualizar.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					
					textFieldId.setText("");
					textFieldInscEst.setText("");
					textFieldNome.setText("");
					textFieldMunicipio.setText("");
					textFieldContato.setText("");
					
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
					
					boolean respostaDeletar = ControllerPropriedade.getInstance().deletar(id);
					
					if (respostaDeletar == true) {
						JOptionPane.showMessageDialog(null, "Propriedade " + id + "\napagada com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Propriedade " + id + "\nOcorreu um erro ao apagar o usuario !", "Erro", JOptionPane.ERROR_MESSAGE);	
					}
					
					textFieldId.setText("");
					textFieldInscEst.setText("");
					textFieldNome.setText("");
					textFieldMunicipio.setText("");
					textFieldContato.setText("");
					
					dispose();
					break;
					
				default:
					break;
				}
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
				textFieldInscEst.setEnabled(true);
				textFieldNome.setEnabled(true);
				textFieldMunicipio.setEnabled(true);
				textFieldContato.setEnabled(true);
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
				textFieldInscEst.setEnabled(false);
				textFieldNome.setEnabled(false);
				textFieldMunicipio.setEnabled(false);
				textFieldContato.setEnabled(false);
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
				textFieldInscEst.setEnabled(true);
				textFieldNome.setEnabled(true);
				textFieldMunicipio.setEnabled(true);
				textFieldContato.setEnabled(true);
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
				textFieldInscEst.setEnabled(false);
				textFieldNome.setEnabled(false);
				textFieldMunicipio.setEnabled(false);
				textFieldContato.setEnabled(false);
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
				textFieldInscEst.setText("");
				textFieldNome.setText("");
				textFieldMunicipio.setText("");
				textFieldContato.setText("");
				textFieldId.setEnabled(false);
				textFieldInscEst.setEnabled(false);
				textFieldNome.setEnabled(false);
				textFieldMunicipio.setEnabled(false);
				textFieldContato.setEnabled(false);
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
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textFieldInscEst, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textFieldNome, 482, 482, 482)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(textFieldMunicipio, 237, 237, 237)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
													.addGap(128)))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldContato, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))))))
							.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
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
					.addComponent(textFieldInscEst, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblNewLabel_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldContato, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(83))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnConfirmar, btnCancelar});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {textFieldMunicipio, lblNewLabel_2, textFieldInscEst});
		contentPane.setLayout(gl_contentPane);
	}

	public String getMenuAtivo() {
		return menuAtivo;
	}

	public void setMenuAtivo(String menuAtivo) {
		this.menuAtivo = menuAtivo;
	}
}
