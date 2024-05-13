package bai10;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		contentPane.add(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFormat = new JMenu("Format");
		menuBar.add(mnFormat);
		
		JMenu mnNewMenu = new JMenu("Color");
		mnFormat.add(mnNewMenu);
		
		JMenuItem mntm_green = new JMenuItem("Xanh lá");
		mntm_green.addActionListener(e -> {
			textArea.setForeground(java.awt.Color.green);
		});
		mnNewMenu.add(mntm_green);
		
		JMenuItem mntm_red = new JMenuItem("Đỏ");
		mntm_red.addActionListener(e -> {
			textArea.setForeground(java.awt.Color.red);
		});
		mnNewMenu.add(mntm_red);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Xanh dương");
		mntmNewMenuItem.addActionListener(e -> {
			textArea.setForeground(java.awt.Color.blue);
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Font");
		mnFormat.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("font1");
		mntmNewMenuItem_1.addActionListener(e -> {
			textArea.setFont(new Font("Arial", textArea.getFont().getStyle(), 12));
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("font2");
		mntmNewMenuItem_2.addActionListener(e -> {
			textArea.setFont(new Font("Times New Roman", textArea.getFont().getStyle(), 12));
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("font3");
		mntmNewMenuItem_3.addActionListener(e -> {
			textArea.setFont(new Font("Tahoma", textArea.getFont().getStyle(), 12));
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("italic");
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(textArea.getFont().deriveFont(2));
			}
		});
		mnNewMenu_1.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("bold");
		rdbtnmntmNewRadioItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(textArea.getFont().deriveFont(1));
			}
		});
		mnNewMenu_1.add(rdbtnmntmNewRadioItem_1);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntm_about = new JMenuItem("About");
		mntm_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Đây là ứng dụng về định dạng văn bản.");
		
			}
		});
		mnFile.add(mntm_about);
		
		JMenuItem mntm_exit = new JMenuItem("Exit");
		mntm_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntm_exit);
	}

}
