package br.com.agrodigital.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;



import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class ViewRelatorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ViewRelatorio() {
		setResizable(false);
		setTitle("Relatórios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelSul, BorderLayout.SOUTH);
		
		JButton btnExibirCustoTotal = new JButton("Relat\u00F3rio de Custo Total");
		btnExibirCustoTotal.setEnabled(false);
		btnExibirCustoTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
//				
			}
		});
		
		JButton btnExibirFluxoDeCaixa = new JButton("Relat\u00F3rio de Fluxo de Caixa");
		btnExibirFluxoDeCaixa.setEnabled(false);
		btnExibirFluxoDeCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}
		});

		GroupLayout gl_panelSul = new GroupLayout(panelSul);
		gl_panelSul.setHorizontalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSul.createSequentialGroup()
					.addGap(155)
					.addComponent(btnExibirCustoTotal, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
					.addComponent(btnExibirFluxoDeCaixa, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
		);
		gl_panelSul.setVerticalGroup(
			gl_panelSul.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSul.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSul.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExibirFluxoDeCaixa, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExibirCustoTotal, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelSul.linkSize(SwingConstants.VERTICAL, new Component[] {btnExibirCustoTotal, btnExibirFluxoDeCaixa});
		gl_panelSul.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnExibirCustoTotal, btnExibirFluxoDeCaixa});
		panelSul.setLayout(gl_panelSul);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_panelNorte = new GroupLayout(panelNorte);
		gl_panelNorte.setHorizontalGroup(
			gl_panelNorte.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelNorte.createSequentialGroup()
					.addGap(393)
					.addComponent(lblNewLabel)
					.addContainerGap(392, Short.MAX_VALUE))
		);
		gl_panelNorte.setVerticalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panelNorte.setLayout(gl_panelNorte);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		
	}
}
