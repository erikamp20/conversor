package Conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConversorTemperatura {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private double C_a_F; 
	private double C_a_K; 
	private double C_a_R; 
	private DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.#####");
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnRegresr;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura window = new ConversorTemperatura();
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
	public ConversorTemperatura() {
		C_a_F = 33.8; 
		C_a_K = 274.15; 
	    C_a_R = 493.47;
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
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
		btnRegresr.setBounds(216, 265, 123, 26);
		panel.add(btnRegresr);
		
		JLabel lblNewLabel = new JLabel("Conversor");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 39));
		lblNewLabel.setBounds(176, 31, 216, 41);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setOpaque(false);
		textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		//textField.setBackground(UIManager.getColor("TextField.background"));
		textField.setColumns(10);
		textField.setBounds(123, 132, 122, 26);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setColumns(10);
		textField_1.setBounds(126, 177, 122, 26);
		textField_1.setOpaque(false);
		textField_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		

		panel.add(textField_1);
		
		//JComboBox<String> comboBox = new JComboBox<String>();
		comboBox = new JComboBox<String>();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvertirTemperatura();
			}

			
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin", "Rankine"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(295, 132, 122, 26);
		panel.add(comboBox);
		
		//JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setForeground(new Color(255, 255, 255));
		comboBox_1.setBackground(new Color(0, 0, 0));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvertirTemperatura();
			}

			
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin", "Rankine"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBounds(295, 174, 122, 26);
		panel.add(comboBox_1);
		
		lblNewLabel_1 = new JLabel("Conversor de temperatura");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(154, 70, 245, 26);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ConversorTemperatura.class.getResource("/Recursos/background.jpg")));
		lblNewLabel_2.setBounds(-58, 0, 630, 360);
		panel.add(lblNewLabel_2);
		

		
	}
	
	
	private void ConvertirTemperatura() {
		String TemperaturaDeOrigen = (String) comboBox.getSelectedItem();
		String TemperaturaDeDestino = (String) comboBox_1.getSelectedItem();

		if (textField.getText().isEmpty())
			return;

		try {
			double Cantidad = Double.parseDouble(textField.getText());
			double CantidadConvertida = 0;

			if (TemperaturaDeOrigen.equals("Celsius")) {
				CantidadConvertida = ConvertirDesdeCelsius(Cantidad, TemperaturaDeDestino);
			} else if (TemperaturaDeDestino.equals("Celsius")) {
				CantidadConvertida = ConvertirACelsius(Cantidad, TemperaturaDeOrigen);
			} else {
				double TemperaturaEquivalente = ConvertirACelsius(Cantidad, TemperaturaDeOrigen);
				CantidadConvertida = ConvertirDesdeCelsius(TemperaturaEquivalente, TemperaturaDeDestino);
			}

			String resultado = DECIMAL_FORMAT.format(CantidadConvertida);
			textField_1.setText(resultado);
			
		} catch (NumberFormatException ex) {
			textField_1.setText("");
		}
		
	}
	
	private double ConvertirACelsius(double cantidad, String temperatura) {
	    switch (temperatura) {
	        
	          
	        case "Fahrenheit":
	            return cantidad / C_a_F;
	        case "Kelvin":
	            return cantidad / C_a_K;
	        case "Rankine":
	            return cantidad / C_a_R;
	       
	        default:
	            return cantidad;     
	    }
	}
	
	private double ConvertirDesdeCelsius(double cantidad, String temperatura) {
	    switch (temperatura) {
	    case "Fahrenheit":
	    	return cantidad * C_a_F;
        case "Kelvin":
            return cantidad * C_a_K;
        case "Rankine":
            return cantidad * C_a_R;
       
        default:
            return cantidad;
	    }
	}
	
	 public JFrame getFrame() {
	        return frame;
	    }
}

