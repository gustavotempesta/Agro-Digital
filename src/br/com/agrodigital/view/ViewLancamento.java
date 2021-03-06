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

import br.com.agrodigital.controller.ControllerLancamento;
import br.com.agrodigital.model.Despesa;
import br.com.agrodigital.model.Lancamento;
import br.com.agrodigital.model.Receita;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewLancamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldDescricao;
	private JTextField textFieldData;
	private JTextField textFieldTipo;
	private JTextField textFieldValor;
	private JTextField textFieldNatureza;
	private String menuAtivo = "";
	
	/**
	 * Create the frame.
	 */
	public ViewLancamento() {
		setResizable(false);
		setTitle("Cadastrar Lan?amento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Id");
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descri??o");
		textFieldDescricao = new JTextField();
		textFieldDescricao.setEnabled(false);
		textFieldDescricao.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data");
		textFieldData = new JTextField();
		textFieldData.setEnabled(false);
		textFieldData.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo");
		textFieldTipo = new JTextField();
		textFieldTipo.setEnabled(false);
		textFieldTipo.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor");
		textFieldValor = new JTextField();
		textFieldValor.setEnabled(false);
		textFieldValor.setColumns(10);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Natureza");
		textFieldNatureza = new JTextField();
		textFieldNatureza.setEnabled(false);
		textFieldNatureza.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String idString;
				String descricao;
				String data;
				String tipo;
				String natureza;
				double valor;
				String valorString;

				switch (menuAtivo) {
				
				case "Adicionar":
					descricao = textFieldDescricao.getText();
					data = textFieldData.getText();
					tipo = textFieldTipo.getText();
					valorString = textFieldValor.getText();
					natureza = textFieldNatureza.getText();
					
					valor = 0;
					try {
						valor = Double.parseDouble(valorString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Valor Inv?lido");
						return;
					}
					
					if (tipo.equals("Despesa")) {
						Despesa despesaAdicionar = new Despesa(descricao, data, tipo, valor, natureza);
						boolean respostaAdicionar = ControllerLancamento.getInstance().adicionar(despesaAdicionar);
						
						if(respostaAdicionar == true) {
							JOptionPane.showMessageDialog(null, despesaAdicionar.toString() + "\ninclu?da com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, despesaAdicionar.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						
					}else if (tipo.equals("Receita")) {
						Receita receitaAdicionar = new Receita(descricao, data, tipo, valor, natureza);
						boolean respostaAdicionar = ControllerLancamento.getInstance().adicionar(receitaAdicionar);
						
						if(respostaAdicionar == true) {
							JOptionPane.showMessageDialog(null, receitaAdicionar.toString() + "\ninclu?da com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, receitaAdicionar.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
							}
					}else {
						JOptionPane.showMessageDialog(null, "\nOcorreu um erro ! \nTipo " + tipo + " inv?lido!", "Erro", JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					textFieldId.setText("");
					textFieldDescricao.setText("");
					textFieldData.setText("");
					textFieldTipo.setText("");
					textFieldValor.setText("");
					textFieldNatureza.setText("");
										
					dispose();
					break;
					
				case "Listar":
					idString = textFieldId.getText();
					
					id = 0;
					try {
						id = Integer.parseInt(idString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID Inv?lido");
						return;
					}
					
					Lancamento lancamentoListar = ControllerLancamento.getInstance().listar(id);
					
					if (lancamentoListar != null) {
						if(lancamentoListar instanceof Receita) {
							Receita receitaListar = (Receita) lancamentoListar;
							textFieldDescricao.setText(receitaListar.getDescricao());
							textFieldData.setText(receitaListar.getData());
							textFieldValor.setText(String.valueOf(receitaListar.getValor()));
							textFieldTipo.setText(receitaListar.getTipo());
							textFieldNatureza.setText(receitaListar.getNatureza());
	
						} else if(lancamentoListar instanceof Despesa) {
							Despesa despesaListar = (Despesa) lancamentoListar;
							textFieldDescricao.setText(despesaListar.getDescricao());
							textFieldData.setText(despesaListar.getData());
							textFieldValor.setText(String.valueOf(despesaListar.getValor()));
							textFieldTipo.setText(despesaListar.getTipo());
							textFieldNatureza.setText(despesaListar.getNatureza());
						}
					}else {
						JOptionPane.showMessageDialog(null, "Lan?amento: " + id + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
					break;
					
				case "Atualizar":
					idString = textFieldId.getText();
					descricao = textFieldDescricao.getText();
					data = textFieldData.getText();
					tipo = textFieldTipo.getText();
					natureza = textFieldNatureza.getText();
					valorString = textFieldValor.getText();
					
					id = 0;
					try {
						id = Integer.parseInt(idString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID Inv?lido");
						return;
					}
					
					valor = 0;
					try {
						valor = Double.parseDouble(valorString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Valor Inv?lido");
						return;
					}
					
					if (tipo.equals("Despesa")) {
						System.out.println("chegou despesa");
						natureza = textFieldNatureza.getText();
						Despesa despesaAdicionar = new Despesa(id, descricao, data, tipo, valor, natureza);
						
						boolean respostaAtualizar = ControllerLancamento.getInstance().atualizar(despesaAdicionar); 
						
						if(respostaAtualizar == true) {
							   JOptionPane.showMessageDialog(null, despesaAdicionar.toString() + "\nalterado com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, despesaAdicionar.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						
					}else if (tipo.equals("Receita")) {
						System.out.println("chegou receita");
						Receita receitaAdicionar = new Receita(id, descricao, data, tipo, valor, natureza);
						
						boolean respostaAtualizar = ControllerLancamento.getInstance().atualizar(receitaAdicionar); 

						if(respostaAtualizar == true) {
							   JOptionPane.showMessageDialog(null, receitaAdicionar.toString() + "\nalterado com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, receitaAdicionar.toString() + "\nOcorreu um erro !", "Erro", JOptionPane.ERROR_MESSAGE);
							}
					}
										
					textFieldId.setText("");
					textFieldDescricao.setText("");
					textFieldData.setText("");
					textFieldTipo.setText("");
					textFieldValor.setText("");
					textFieldNatureza.setText("");
					
					dispose();
					break;
					
				case "Deletar":
					idString = textFieldId.getText();
					
					id = 0;
					try {
						id = Integer.parseInt(idString);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ID Inv?lido");
						return;
					}
					
					boolean respostaDeletar = ControllerLancamento.getInstance().deletar(id);
					
					if (respostaDeletar == true) {
						JOptionPane.showMessageDialog(null, "Lan?amento " + id + "\napagado com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Lan?amento  " + id + "\nOcorreu um erro ao apagar o usuario !", "Erro", JOptionPane.ERROR_MESSAGE);	
					}
					textFieldId.setText("");
					textFieldDescricao.setText("");
					textFieldData.setText("");
					textFieldTipo.setText("");
					textFieldValor.setText("");
					textFieldNatureza.setText("");		
					
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
				textFieldDescricao.setEnabled(true);
				textFieldData.setEnabled(true);
				textFieldTipo.setEnabled(true);
				textFieldValor.setEnabled(true);
				textFieldNatureza.setEnabled(true);
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
				textFieldDescricao.setEnabled(false);
				textFieldData.setEnabled(false);
				textFieldTipo.setEnabled(false);
				textFieldValor.setEnabled(false);
				textFieldNatureza.setEnabled(false);
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
				textFieldDescricao.setEnabled(true);
				textFieldData.setEnabled(true);
				textFieldTipo.setEnabled(true);
				textFieldValor.setEnabled(true);
				textFieldNatureza.setEnabled(true);
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
				textFieldDescricao.setEnabled(false);
				textFieldData.setEnabled(false);
				textFieldTipo.setEnabled(false);
				textFieldValor.setEnabled(false);
				textFieldNatureza.setEnabled(false);
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
				textFieldDescricao.setText("");
				textFieldData.setText("");
				textFieldTipo.setText("");
				textFieldNatureza.setText("");
				textFieldValor.setText("");
				textFieldId.setEnabled(false);
				textFieldDescricao.setEnabled(false);
				textFieldData.setEnabled(false);
				textFieldTipo.setEnabled(false);
				textFieldValor.setEnabled(false);
				textFieldNatureza.setEnabled(false);
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldDescricao, 482, 482, 482)
							.addComponent(textFieldNatureza, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(243)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldTipo, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldData, 237, 237, 237)
									.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldValor, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeletar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldTipo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldDescricao, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1)
							.addGap(1)))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldValor, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_1_1_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNatureza, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnConfirmar, btnCancelar});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {textFieldData, lblNewLabel_2, textFieldTipo});
		contentPane.setLayout(gl_contentPane);
	}
	
	public String getMenuAtivo() {
		return menuAtivo;
	}

	public void setMenuAtivo(String menuAtivo) {
		this.menuAtivo = menuAtivo;
	}
}
