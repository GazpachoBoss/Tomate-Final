package panelComunes;

import java.util.Stack;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Identificacion extends JPanel{

	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField txtNacimiento;
	private JTextField textTelefono;
	
	private Stack<JTextField> misTxtsFields = new Stack<>();
	private JLabel lblNacimiento;
	
	/**
	 * Create the frame.
	 */
	public Identificacion() {
		
		setBounds(100, 100, 446, 157);
		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		lblNacimiento = new JLabel("Nacimiento");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
										.addGap(4))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(lblNacimiento, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textNombre, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
								.addComponent(textApellidos, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
								.addComponent(textDireccion, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textTelefono, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
										.addComponent(txtNacimiento, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
									.addGap(217))))
						.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textApellidos))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(textDireccion))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNacimiento)
						.addComponent(txtNacimiento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textTelefono))
					.addGap(16))
		);
		this.setLayout(gl_contentPane);

		misTxtsFields.add(textNombre);
		misTxtsFields.add(textApellidos);
		misTxtsFields.add(textDireccion);
		misTxtsFields.add(txtNacimiento);
		misTxtsFields.add(textTelefono);
	}
	
	public void deshabilitarCampo(int [] campos) {
		for (int i = 0; i < campos.length; i++) {
			misTxtsFields.get(campos[i]).setEditable(false);
		}
			
	}
	
	public JLabel getLblNacimiento() {
		return lblNacimiento;
	}

	public JPanel getContentPane() {
		return this;
	}
	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	public void setTextApellidos(JTextField textApellidos) {
		this.textApellidos = textApellidos;
	}

	public JTextField getTextDireccion() {
		return textDireccion;
	}

	public void setTextDireccion(JTextField textDireccion) {
		this.textDireccion = textDireccion;
	}

	public JTextField getTxtNacimiento() {
		return txtNacimiento;
	}

	public void setTxtNacimiento(JTextField txtNacimiento) {
		this.txtNacimiento = txtNacimiento;
	}

	public JTextField getTextTelefono() {
		return textTelefono;
	}

	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}

	public Stack<JTextField> getMisTxtsFields() {
		return misTxtsFields;
	}

	public void setMisTxtsFields(Stack<JTextField> misTxtsFields) {
		this.misTxtsFields = misTxtsFields;
	}
}
