package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Servicios.Programa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class Eliminar {

	private JFrame frmEliminarPaciente;
	private JTextField IngresaDniEliminar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminar window = new Eliminar(null);
					window.frmEliminarPaciente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Eliminar(Programa comand) {
		initialize(comand);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Programa comand) {
		frmEliminarPaciente = new JFrame();
		frmEliminarPaciente.setIconImage(Toolkit.getDefaultToolkit().getImage(Eliminar.class.getResource("/IMG/IconEliminar.PNG")));
		frmEliminarPaciente.setTitle("Eliminar paciente ");
		frmEliminarPaciente.setResizable(false);
		frmEliminarPaciente.setBounds(100, 100, 510, 488);
		frmEliminarPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEliminarPaciente.getContentPane().setLayout(null);
		frmEliminarPaciente.setLocationRelativeTo(null);
		
		frmEliminarPaciente.setVisible(true);
		
		IngresaDniEliminar = new JTextField();
		IngresaDniEliminar.setFont(new Font("Tahoma", Font.BOLD, 22));
		IngresaDniEliminar.setOpaque(false);
		IngresaDniEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char aux = evt.getKeyChar();
				if(IngresaDniEliminar.getText().length() >= 8) {
					evt.consume();
				}
				if(aux < '0' || aux > '9') {
					evt.consume();
				}
			}
		});
		IngresaDniEliminar.setBounds(199, 300, 237, 39);
		frmEliminarPaciente.getContentPane().add(IngresaDniEliminar);
		IngresaDniEliminar.setColumns(10);
		
		JButton btnEliminarDni = new JButton("");
		btnEliminarDni.setToolTipText("Elimina la persona ");
		btnEliminarDni.setIcon(new ImageIcon(Eliminar.class.getResource("/IMG/NeonRojo.jpg")));
		btnEliminarDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dni = Integer.parseInt(IngresaDniEliminar.getText());
				boolean esta = comand.eliminarPaciente(dni);
				if(esta) {
					JOptionPane.showMessageDialog(null, "Se elimino con exito");
					frmEliminarPaciente.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Esa persona no se encuentra en el sistema");
				}
			}
		});
		btnEliminarDni.setBounds(260, 371, 176, 29);
		frmEliminarPaciente.getContentPane().add(btnEliminarDni);
		
		btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Cancela la operacion");
		btnCancelar.setIcon(new ImageIcon(Eliminar.class.getResource("/IMG/NeonAmari.jpg")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmEliminarPaciente.dispose();
			}
		});
		btnCancelar.setBounds(29, 371, 176, 29);
		frmEliminarPaciente.getContentPane().add(btnCancelar);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Eliminar.class.getResource("/IMG/eliminarSpi.png")));
		fondo.setBounds(0, -41, 594, 497);
		frmEliminarPaciente.getContentPane().add(fondo);
	}
}
