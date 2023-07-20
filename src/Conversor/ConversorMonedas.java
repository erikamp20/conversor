package Conversor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConversorMonedas{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;

	private double MX_A_USD; // dolar
	private double MX_A_EURO; // euro
	private double MX_A_GBP; // libra esterlina
	private double MX_A_JPY; // yen japones
	private double MX_A_KRW; // won sul coreano
	private DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.#####");
	private JLabel lblNewLabel_1;
	private JButton btnRegresr;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorMonedas window = new ConversorMonedas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConversorMonedas() {
		MX_A_USD = 0.058; // dolar
		MX_A_EURO = 0.053; // euro
		MX_A_GBP = 0.045; // libra esterlina
		MX_A_JPY = 8.29; // yen japones
		MX_A_KRW = 75.72; // won sul coreano
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 392);
		frame.setTitle("ConverSource");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-12, 0, 591, 364);
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
				panel.setLayout(null);
				
		btnRegresr = new JButton("Regresar");
		btnRegresr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
	               principal.getFrame().setVisible(true);
	               frame.setVisible(false);
			}
		});
		btnRegresr.setForeground(Color.WHITE);
		btnRegresr.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
		btnRegresr.setBackground(new Color(34, 104, 210));
		btnRegresr.setBounds(226, 264, 123, 26);
		panel.add(btnRegresr);
		
		JLabel lblNewLabel = new JLabel("Conversor");
		lblNewLabel.setBounds(192, 33, 206, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 39));
				
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBounds(131, 179, 122, 26);
		textField_1.setOpaque(false);
		textField_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		panel.add(textField_1);
		textField_1.setColumns(10);
						
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBounds(131, 142, 122, 26);
		textField.setOpaque(false);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		panel.add(textField);
		textField.setColumns(10);
								
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setForeground(new Color(255, 255, 255));
		comboBox_1.setBackground(new Color(0, 0, 0));
		comboBox_1.setBounds(313, 176, 122, 26);
	    panel.add(comboBox_1);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Peso Mexicano", "Dolar", "Euros", "Libras Esterlinas", "Yen Japones ", "Won sul-coreano"}));
										
		comboBox = new JComboBox<String>();
	    comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setBounds(313, 139, 122, 26);
		panel.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Peso Mexicano", "Dolar", "Euros", "Libras Esterlinas", "Yen Japones ", "Won sul-coreano"}));
												
	    lblNewLabel_1 = new JLabel("Conversor de divisas");
		lblNewLabel_1.setBounds(202, 67, 184, 26);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
												
	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setIcon(new ImageIcon(ConversorMonedas.class.getResource("/Recursos/background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 581, 353);
	    panel.add(lblNewLabel_2);
												
	    comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		ConvertirMoneda();
		}
		});
										
		comboBox_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		ConvertirMoneda();
		}
		});
	}

	private void ConvertirMoneda() {
		String MonedaDeOrigen = (String) comboBox.getSelectedItem();
		String MonedaDeDestino = (String) comboBox_1.getSelectedItem();

		if (textField.getText().isEmpty())
			return;

		try {
			double Cantidad = Double.parseDouble(textField.getText());
			double CantidadConvertida = 0;

			if (MonedaDeOrigen.equals("Peso Mexicano")) {
				CantidadConvertida = ConvertirDesdePesoMexicano(Cantidad, MonedaDeDestino);
			} else if (MonedaDeDestino.equals("Peso Mexicano")) {
				CantidadConvertida = ConvertirAPesoMexicano(Cantidad, MonedaDeOrigen);
			} else {
				double PesoEquivalente = ConvertirAPesoMexicano(Cantidad, MonedaDeOrigen);
				CantidadConvertida = ConvertirDesdePesoMexicano(PesoEquivalente, MonedaDeDestino);
			}

			String resultado = DECIMAL_FORMAT.format(CantidadConvertida);
			textField_1.setText(resultado);
			
		} catch (NumberFormatException ex) {
			textField_1.setText("");
		}
	}

	private double ConvertirAPesoMexicano(double cantidad, String moneda) {
	    switch (moneda) {
	        
	            
	        case "Dolar":
	            return cantidad / MX_A_USD;
	        case "Euros":
	            return cantidad / MX_A_EURO;
	        case "Libras Esterlinas":
	            return cantidad / MX_A_GBP;
	        case "Yen Japones ":
	            return cantidad / MX_A_JPY;
	        case "Won sul-coreano":
	            return cantidad / MX_A_KRW;
	        default:
	            return cantidad;     
	    }
	}

	private double ConvertirDesdePesoMexicano(double cantidad, String moneda) {
	    switch (moneda) {
	    case "Dolar":
            return cantidad * MX_A_USD;
        case "Euros":
            return cantidad * MX_A_EURO;
        case "Libras Esterlinas":
            return cantidad * MX_A_GBP;
        case "Yen Japones ":
            return cantidad * MX_A_JPY;
        case "Won sul-coreano":
            return cantidad * MX_A_KRW;
        default:
            return cantidad;
	    }
	}

	 public JFrame getFrame() {
	        return frame;
	    }
	}

