package IdentificadorMelhorRota;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FrmGrafo extends JFrame {

	private static final long serialVersionUID = -2470641513546958576L;
	private JPanel contentPane;
	private JTextField txtSaida;
	private JTextField txtDestino;
	private JTextField txtVlGasolina;
	private JTextField txtMenorCaminho;
	private JTextField txtMelhorCaminho;

	/**
	 * Create the frame.
	 */
	public FrmGrafo() {
		setResizable(false);
		setTitle("Grafo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaida = new JLabel("Sa\u00EDda:");
		lblSaida.setBounds(23, 22, 46, 20);
		contentPane.add(lblSaida);
		
		txtSaida = new JTextField();
		txtSaida.setBounds(103, 22, 86, 20);
		contentPane.add(txtSaida);
		txtSaida.setColumns(10);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(23, 53, 46, 20);
		contentPane.add(lblDestino);
		
		txtDestino = new JTextField();
		txtDestino.setBounds(103, 53, 86, 20);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);
		
		JLabel lblValorGasolina = new JLabel("Valor gasolina:");
		lblValorGasolina.setBounds(23, 84, 70, 20);
		contentPane.add(lblValorGasolina);
		
		txtVlGasolina = new JTextField();
		txtVlGasolina.setBounds(103, 84, 86, 20);
		contentPane.add(txtVlGasolina);
		txtVlGasolina.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 115, 389, 2);
		contentPane.add(separator);
		
		JLabel lblMenorCaminho = new JLabel("Menor caminho");
		lblMenorCaminho.setBounds(23, 128, 86, 20);
		contentPane.add(lblMenorCaminho);
		
		txtMenorCaminho = new JTextField();
		txtMenorCaminho.setBackground(Color.WHITE);
		txtMenorCaminho.setEditable(false);
		txtMenorCaminho.setBounds(23, 153, 389, 20);
		contentPane.add(txtMenorCaminho);
		txtMenorCaminho.setColumns(10);
		
		JLabel lblMelhorCaminho = new JLabel("Melhor caminho");
		lblMelhorCaminho.setBounds(23, 184, 86, 20);
		contentPane.add(lblMelhorCaminho);
		
		txtMelhorCaminho = new JTextField();
		txtMelhorCaminho.setBackground(Color.WHITE);
		txtMelhorCaminho.setEditable(false);
		txtMelhorCaminho.setBounds(23, 209, 389, 20);
		contentPane.add(txtMelhorCaminho);
		txtMelhorCaminho.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Chamar classe aqui!
				
			}
		});
		btnCalcular.setBounds(323, 21, 89, 52);
		contentPane.add(btnCalcular);
	}
	
	public static void main(String[] args) {
		new FrmGrafo();
	}
	
}
