package bai9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JRadioButton btn_thuong = new JRadioButton("Thuong");
		panel.add(btn_thuong);
		
		JRadioButton btn_dam = new JRadioButton("Bôi đậm");
		panel.add(btn_dam);
		
		JRadioButton btn_inNghieng = new JRadioButton("In nghiêng");
		panel.add(btn_inNghieng);
		
		JRadioButton btn_both = new JRadioButton("In nghiêng và Bôi đậm");
		panel.add(btn_both);
		
		btn_thuong.addActionListener(e -> {
			textArea.setFont(textArea.getFont().deriveFont(0));
		});
		btn_dam.addActionListener(e -> {
			textArea.setFont(textArea.getFont().deriveFont(1));
		});
		btn_inNghieng.addActionListener(e -> {
			textArea.setFont(textArea.getFont().deriveFont(2));
		});
		btn_both.addActionListener(e -> {
			textArea.setFont(textArea.getFont().deriveFont(3));
		});
		
		
		
	}

}
