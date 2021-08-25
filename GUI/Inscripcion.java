package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Servicios.Programa;
import java.awt.Toolkit;

public class Inscripcion extends Menu{

	
	private JFrame frmInscripcion;
	private JTextField Name;
	private JTextField surname;
	private JTextField Dni;
	private JRadioButton riskTwo;
	private JRadioButton riskFour;
	private JRadioButton riskFive;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscripcion window = new Inscripcion(null);
					window.frmInscripcion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inscripcion(Programa app) {
		initialize(app);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Programa app) {
		
		frmInscripcion = new JFrame();
		frmInscripcion.setIconImage(Toolkit.getDefaultToolkit().getImage(Inscripcion.class.getResource("/IMG/pandemic_epidemic_earth_covid_coronavirus_diffuse_disease_icon_141605.png")));
		frmInscripcion.setResizable(false);
		frmInscripcion.setTitle("Inscripcion");
		frmInscripcion.setBounds(new Rectangle(0, 0, 500, 500));
		frmInscripcion.setBounds(500, 100, 508, 517);
		frmInscripcion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInscripcion.getContentPane().setLayout(null);
		frmInscripcion.setVisible(true);
		frmInscripcion.setLocationRelativeTo(null);
		
		Name = new JTextField();
		Name.setToolTipText("Ingrese aqui su nombre.");
		Name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char aux = evt.getKeyChar();
				/*
                 * Este if permite que en el campo del nomre solo se puedean ingresar letras, tanto 
                 * en minuscula como en mayuscula 
                 */
				if((aux < 'a' || aux > 'z') && (aux < 'A' || aux > 'Z') && !(aux == ' ')) {
					evt.consume();
				}
			}
		});
		Name.setBorder(new EmptyBorder(0, 0, 0, 0));
		Name.setForeground(SystemColor.inactiveCaptionBorder);
		Name.setFont(new Font("Tahoma", Font.BOLD, 18));
		Name.setOpaque(false);
		Name.setBounds(54, 112, 178, 44);
		frmInscripcion.getContentPane().add(Name);
		Name.setColumns(10);
		
		surname = new JTextField();
		surname.setToolTipText("Ingrese aqui su apellido");
		surname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				/*
                 * Este if permite que en el campo del apellido solo se puedean ingresar letras, tanto 
                 * en minuscula como en mayuscula 
                 */
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
					evt.consume();
				}
			}
		});
		surname.setOpaque(false);
		surname.setForeground(SystemColor.inactiveCaptionBorder);
		surname.setFont(new Font("Tahoma", Font.BOLD, 18));
		surname.setColumns(10);
		surname.setBorder(new EmptyBorder(0, 0, 0, 0));
		surname.setBounds(287, 112, 165, 44);
		frmInscripcion.getContentPane().add(surname);
		
		Dni = new JTextField();
		Dni.setToolTipText("Ingrese aqui su DNI");
		Dni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				/*
                 * Esto hace que solo se pueda ingresar hasta un maximo de 8 digitos en el campo del DNI
                 */
				char aux = evt.getKeyChar();
				if(Dni.getText().length() >= 8) {
					evt.consume();
				}
				/*
                 * Esto hace que solo se puedan ingresar numeros en el campo del DNI
                 */
				if(aux < '0' || aux > '9') {
					evt.consume();
				}
			}
		});
		Dni.setForeground(SystemColor.inactiveCaptionBorder);
		Dni.setFont(new Font("Tahoma", Font.BOLD, 19));
		Dni.setBorder(new EmptyBorder(0, 0, 0, 0));
		Dni.setOpaque(false);
		Dni.setBounds(167, 218, 197, 44);
		frmInscripcion.getContentPane().add(Dni);
		Dni.setColumns(10);
		
		JRadioButton riskOne = new JRadioButton("");
		riskOne.setToolTipText("");
		riskOne.setOpaque(false);
		riskOne.setBounds(212, 319, 20, 23);
		frmInscripcion.getContentPane().add(riskOne);
		
		JRadioButton riskThree = new JRadioButton("");
		riskThree.setOpaque(false);
		riskThree.setBounds(291, 319, 20, 23);
		frmInscripcion.getContentPane().add(riskThree);
		
		riskTwo = new JRadioButton("");
		riskTwo.setOpaque(false);
		riskTwo.setBounds(253, 319, 20, 23);
		frmInscripcion.getContentPane().add(riskTwo);
		
		riskFour = new JRadioButton("");
		riskFour.setOpaque(false);
		riskFour.setBounds(333, 319, 20, 23);
		frmInscripcion.getContentPane().add(riskFour);
		
		riskFive = new JRadioButton("");
		riskFive.setOpaque(false);
		riskFive.setBounds(374, 319, 20, 23);
		frmInscripcion.getContentPane().add(riskFive);
		
		//Creamos el grupo de radio botones
		ButtonGroup teamButton = new ButtonGroup();
		
		//Asiganmos los radioButton al teamButton
		teamButton.add(riskOne);
		teamButton.add(riskTwo);
		teamButton.add(riskThree);
		teamButton.add(riskFour);
		teamButton.add(riskFive);
		
		JButton toRegister = new JButton("");
		toRegister.setToolTipText("Finalizar Inscripcion");
		toRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boolean paso = true;
				
				if(Name.getText().isEmpty()) { // estamos validando que el usuario complete el campo del nombre
					JOptionPane.showMessageDialog(null, "Falto poner su Nombre");
					paso = false;
				}
				else {
					paso = true;
				}
				
				if(surname.getText().isEmpty()) { // estamos validando que el usuario complete el campo del apellido
					JOptionPane.showMessageDialog(null, "Falto poner su Nombre");
					paso = false;
				}
				else {
					paso = paso && true;
				}
				
				if(Dni.getText().isEmpty()) { // estamos validando que el usuario complete el campo del DNI
					JOptionPane.showMessageDialog(null, "Falto poner su DNI");
					paso = false;
				}
				else {
					paso = paso && true;
					if(Dni.getText().length() != 8) { // estamos validando que el dni tenga 8 digitos
						JOptionPane.showMessageDialog(null, "DNI invalido");
						paso = false;
					}else {
						paso = paso && true;
					}
				}
				if(teamButton.isSelected(null)) { // estamos validando que el usuario seleccione el riesgo
					JOptionPane.showMessageDialog(null, "Falto seleccionar el riesgo");
					paso = false;
				}
				else {
					paso = paso && true;
				}				
				/*
                 * Le asigno a cada radioButton un int del 1 al 5
                 */
				int r = 1;
				if(riskOne.isSelected()) {
					r = 1;
				}
				if(riskTwo.isSelected()) {
					r = 2;
				}
				if(riskThree.isSelected()) {
					r = 3;
				}
				if(riskFour.isSelected()) {
					r = 4;
				}
				if(riskFive.isSelected()) {
					r = 5;
				}
				
				if(paso) {					
					app.insert(Name.getText(), surname.getText(),Integer.parseInt(Dni.getText()),r);
					JOptionPane.showMessageDialog(null, "Se registro con exito");
					frmInscripcion.setVisible(false);
				}
				
			}
		});
		toRegister.setIcon(new ImageIcon(Inscripcion.class.getResource("/IMG/Registrarse.png")));
		toRegister.setOpaque(false);
		toRegister.setBounds(44, 423, 183, 44);
		toRegister.setOpaque(false);
		frmInscripcion.getContentPane().add(toRegister);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Inscripcion.class.getResource("/IMG/inscripcion.png")));
		Fondo.setBounds(0, 0, 504, 478);
		frmInscripcion.getContentPane().add(Fondo);
	}
}
