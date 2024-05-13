package bai7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("đỏ");
		rdbtnNewRadioButton_3.addActionListener(e->{
			contentPane.setBackground(java.awt.Color.red);

		});
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("vàng");
		rdbtnNewRadioButton_2.addActionListener(e -> {
			contentPane.setBackground(java.awt.Color.yellow);

		});
		
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("đen");
		rdbtnNewRadioButton_1.addActionListener(e -> {
			contentPane.setBackground(java.awt.Color.black);

		});
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("tím");
		rdbtnNewRadioButton.addActionListener(e -> {
			contentPane.setBackground(java.awt.Color.magenta);

		});
		contentPane.add(rdbtnNewRadioButton);
		
	}

}
