import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setTitle("Peque\u00F1o Formulario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(37, 38, 56, 37);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(95, 46, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ciudad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(37, 87, 48, 14);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Escoja una ciudad", "Barcelona", "Cornella" }));
		comboBox.setBounds(95, 83, 126, 22);
		contentPane.add(comboBox);

		JLabel lblAficiones = new JLabel("Aficiones");
		lblAficiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblAficiones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAficiones.setBounds(37, 137, 56, 14);
		contentPane.add(lblAficiones);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Golf");
		chckbxNewCheckBox.setBounds(47, 158, 61, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxTennis = new JCheckBox("Tenis");
		chckbxTennis.setBounds(47, 191, 61, 23);
		contentPane.add(chckbxTennis);

		JCheckBox chckbxPadel = new JCheckBox("Padel");
		chckbxPadel.setBounds(110, 158, 61, 23);
		contentPane.add(chckbxPadel);

		JCheckBox chckbxPetanca = new JCheckBox("Petanca");
		chckbxPetanca.setBounds(110, 191, 99, 23);
		contentPane.add(chckbxPetanca);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenero.setBounds(253, 137, 56, 14);
		contentPane.add(lblGenero);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(281, 158, 109, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnMujer);
		rdbtnMujer.setBounds(281, 191, 109, 23);
		contentPane.add(rdbtnMujer);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || (comboBox.getSelectedItem().equals("Escoja una ciudad"))
						|| (!rdbtnNewRadioButton.isSelected() && !rdbtnMujer.isSelected())) {
					JOptionPane.showMessageDialog(null, "Falta campos por rellenar", "Aviso",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String checkboxesLabel = "";
					String radioBttnHombreMujer = "";
					if (rdbtnNewRadioButton.isSelected()) {
						radioBttnHombreMujer = "Hombre";
					} else if (rdbtnMujer.isSelected()) {
						radioBttnHombreMujer = "Mujer";
					}
					if (chckbxNewCheckBox.isSelected()) {
						checkboxesLabel = "GOLF ";
					}
					if (chckbxTennis.isSelected()) {
						checkboxesLabel = checkboxesLabel + "TENIS ";
					}
					if (chckbxPadel.isSelected()) {
						checkboxesLabel = checkboxesLabel + "PADEL ";
					}
					if (chckbxPetanca.isSelected()) {
						checkboxesLabel = checkboxesLabel + "PETANCA";
					}

					resumen res = new resumen(
							"Nombre:" + textField.getText() + "\nCiudad: " + comboBox.getSelectedItem()
									+ "\nAficiones: " + checkboxesLabel + "\nGenero: " + radioBttnHombreMujer);
					res.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(32, 228, 358, 23);
		contentPane.add(btnNewButton);
	}
}
