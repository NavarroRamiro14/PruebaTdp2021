package GUI;

import Servicios.Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;

public class Menu {

	private JFrame frame;
	private JLabel lblPizarra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Programa app = new Programa();//Se genera una instancia de la aplicacion logica.
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/IMG/cardiogram.png")));
		frame.setTitle("Protecto Vacunas - Menu");
		frame.setBounds(100, 100, 753, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnInscribir = new JButton("Inscribirse");
		btnInscribir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnInscribir.setToolTipText("Crear nuevo usuario");
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("unused")
					Inscripcion inscripcion = new Inscripcion(app);
			}
		});
		btnInscribir.setBounds(10, 91, 188, 35);
		frame.getContentPane().add(btnInscribir);
		
		JButton btnPacienteRiesgoso = new JButton("Paciente mas Riesgoso");
		btnPacienteRiesgoso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPacienteRiesgoso.setToolTipText("Muestra en pantalla el paciente mas riesgoso.");
		btnPacienteRiesgoso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = app.pacienteMasRiesgoso();
				String ds = "<h1> Paciente Mas Riesgoso <p>";
                lblPizarra.setText("<html><center> <DIV ALIGN=x>"+ ds + s);
			}
		});
		btnPacienteRiesgoso.setBounds(10, 337, 188, 72);
		frame.getContentPane().add(btnPacienteRiesgoso);
		
		JButton btnListarPacientes = new JButton("Listar todos los pacientes");
		btnListarPacientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String s = app.listarPacientes();
                String ds = "<h1> Lista Pacientes <p>";
                lblPizarra.setText("<html><center> <DIV ALIGN=x>"+ ds + s);
			}
		});
		btnListarPacientes.setToolTipText("Muestra en pantalla una lista con todos los pacientes.");
		btnListarPacientes.setBounds(10, 148, 188, 71);
		frame.getContentPane().add(btnListarPacientes);
		
		JButton btnListarPacientesInv = new JButton("Listar Pacientes Invertidos");
		btnListarPacientesInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = app.listarPacientesInvertidos();
				String ds = "<h1> Lista Pacientes Invertidos <p>";
                lblPizarra.setText("<html><center> <DIV ALIGN=x>"+ ds + s);
			}
		});
		btnListarPacientesInv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarPacientesInv.setToolTipText("Muestra en pantalla la lista de todos los pacientes invertidos.");
		btnListarPacientesInv.setBounds(10, 247, 188, 68);
		frame.getContentPane().add(btnListarPacientesInv);
		
		JButton btnEliminarPaciente = new JButton("Eliminar Paciente");
		btnEliminarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Eliminar command = new Eliminar(app);
			}
		});
		btnEliminarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEliminarPaciente.setToolTipText("Permite eliminar un paciente ingresando su DNI");
		btnEliminarPaciente.setBounds(509, 339, 182, 68);
		frame.getContentPane().add(btnEliminarPaciente);
		
		JButton btnPacientesHistoricos = new JButton("Pacientes Historicos");
		btnPacientesHistoricos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = app.pacientesHistoricos();
				String ds = "<h1> Lista Pacientes Historicos <p>";
                lblPizarra.setText("<html><center> <DIV ALIGN=x>"+ ds + s);
			}
		});
		btnPacientesHistoricos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPacientesHistoricos.setToolTipText("Muestra en pantalla una lista con los pacientes historicos eliminados.");
		btnPacientesHistoricos.setBounds(259, 339, 182, 68);
		frame.getContentPane().add(btnPacientesHistoricos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		 JViewport viewport = new JViewport();
	           viewport.setView(new JPanel());
	           viewport.setOpaque(false);
	           viewport.setOpaque(false);
	           scrollPane_1.setViewport(viewport);
	           scrollPane_1.getViewport().setOpaque(false);
	           scrollPane_1.setOpaque(false);
		scrollPane_1.setBounds(243, 91, 468, 215);
		frame.getContentPane().add(scrollPane_1, BorderLayout.CENTER);
		
		lblPizarra = new JLabel("");
		scrollPane_1.setViewportView(lblPizarra);
		lblPizarra.setVerticalAlignment(SwingConstants.TOP);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Menu.class.getResource("/IMG/IMG Menu.png")));
		lblFondo.setBounds(-52, 0, 800, 450);
		frame.getContentPane().add(lblFondo);
	}
}
