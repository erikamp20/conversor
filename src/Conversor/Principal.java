package Conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
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
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
		btnSalir.setBackground(new Color(34, 104, 210));
		btnSalir.setBounds(232, 298, 94, 26);
		panel.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("Conversor");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 39));
		lblNewLabel.setBounds(183, 46, 197, 56);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quiero convertir");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(208, 116, 138, 34);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Divisas");
		 btnNewButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               ConversorMonedas cm = new ConversorMonedas();
	               cm.getFrame().setVisible(true);
	               frame.setVisible(false);
	            }
	        });
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(34, 104, 210));
		btnNewButton.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
		btnNewButton.setBounds(128, 192, 123, 26);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Temperatura");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversorTemperatura ct = new ConversorTemperatura();
	               ct.getFrame().setVisible(true);
	               frame.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(34, 104, 210));
		btnNewButton_1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
		btnNewButton_1.setBounds(284, 192, 138, 26);
		
		
		
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/Recursos/background.jpg")));
		lblNewLabel_2.setBounds(0, -23, 561, 399);
		panel.add(lblNewLabel_2);
	}
	
	public JFrame getFrame() {
        return frame;
    }
}
