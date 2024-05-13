package bai6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

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
		
		
		String[] TheLoai= {"Khoa học", "Kinh tế", "Văn học", "Tâm lý", "Tình cảm","Công nghệ", "Lịch sử", "Thể thao", "Du lịch"};
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "Khoa học", "Kinh tế", "Văn học", "Tâm lý", "Tình cảm", "Công nghệ",
					"Lịch sử", "Thể thao", "Du lịch" };
			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
	
		JButton btnNewButton = new JButton("Chọn");
		JList<String> list_1 = new JList<String>();
		btnNewButton.addActionListener(e -> {
			list_1.setListData(list.getSelectedValuesList().toArray(new String[0]));
		});
		contentPane.add(scrollPane);
		contentPane.add(btnNewButton);
		contentPane.add(list_1);
		
		

	}

}
