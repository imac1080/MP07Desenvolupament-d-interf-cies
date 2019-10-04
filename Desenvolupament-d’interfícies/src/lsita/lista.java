package lsita;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lista frame = new lista();
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
	public lista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		list.setBounds(10, 33, 158, 251);
		contentPane.add(list);

		DefaultListModel<String> model2 = new DefaultListModel<>();
		JList<String> list_1 = new JList<>(model2);
		list_1.setBounds(299, 33, 158, 251);
		contentPane.add(list_1);

		JButton btnMatricular = new JButton("matricular");
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.isSelectionEmpty()) {

				} else {
					model2.addElement(list.getSelectedValue());
					model.remove(list.getSelectedIndex());
				}
			}
		});
		btnMatricular.setBounds(188, 105, 101, 23);
		contentPane.add(btnMatricular);

		JButton btnQuitar = new JButton("quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_1.isSelectionEmpty()) {

				} else {
					model.addElement(list_1.getSelectedValue());
					model2.remove(list_1.getSelectedIndex());
				}
			}
		});
		btnQuitar.setBounds(188, 187, 101, 23);
		contentPane.add(btnQuitar);

		textField = new JTextField();
		textField.setBounds(40, 410, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnAadir = new JButton("inscribir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.contains(textField.getText()) || model2.contains(textField.getText())) {

				} else {
					model.addElement(textField.getText());
				}

			}
		});
		btnAadir.setBounds(157, 379, 89, 23);
		contentPane.add(btnAadir);

		JButton btnEliminarSeleccionado = new JButton("eliminar seleccionado");
		btnEliminarSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.remove(list.getSelectedIndex());
			}
		});
		btnEliminarSeleccionado.setBounds(40, 441, 172, 23);
		contentPane.add(btnEliminarSeleccionado);

		JLabel lblInscribirAlumno = new JLabel("Inscribir alumno:");
		lblInscribirAlumno.setBounds(40, 383, 107, 14);
		contentPane.add(lblInscribirAlumno);
	}
}
