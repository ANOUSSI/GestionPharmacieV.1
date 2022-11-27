package interfaces;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import connexion.HttpConnexion;
import model.User;
import service.UserService;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrameConnexion {
	private JFrame frmGestionDePgormacie;
	private JTextField textField;
	private JPasswordField passwordField;
	UserService service = new UserService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FrameConnexion window = new FrameConnexion();
					window.frmGestionDePgormacie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameConnexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmGestionDePgormacie = new JFrame();
		frmGestionDePgormacie.setTitle("Gestion de pgormacie");
		frmGestionDePgormacie.setResizable(true);
		frmGestionDePgormacie.setAutoRequestFocus(true);
		frmGestionDePgormacie.setEnabled(true);
		frmGestionDePgormacie.revalidate();
		frmGestionDePgormacie.setBounds(100, 100, 450, 257);
		frmGestionDePgormacie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDePgormacie.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenue a la phamacie");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLUE);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(113, 11, 209, 50);
		frmGestionDePgormacie.getContentPane().add(lblNewLabel);

		JLabel lbLogin = new JLabel("User Name");
		lbLogin.setBackground(Color.BLUE);
		lbLogin.setForeground(Color.BLUE);
		lbLogin.setBounds(36, 72, 82, 14);
		frmGestionDePgormacie.getContentPane().add(lbLogin);

		JButton btnNewButton = new JButton("New button");

		JLabel lbpassword = new JLabel("Mot de passe");
		lbpassword.setForeground(Color.BLUE);
		lbpassword.setBounds(36, 116, 82, 14);
		frmGestionDePgormacie.getContentPane().add(lbpassword);

		textField = new JTextField();
		textField.setBounds(138, 69, 168, 20);
		frmGestionDePgormacie.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(138, 113, 168, 20);
		frmGestionDePgormacie.getContentPane().add(passwordField);

		// System.out.println(connexeion.getName());
		JButton btConnexion = new JButton("Connexion");

		btConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HttpConnexion connexeion = new HttpConnexion();
				
				System.out.println("ddddqfsqdfsdqfsdf");

				// if(textField.getText().toString().equals("noussi") &&
				// passwordField.getText().toString().equals("noussi"))
				// if(textField.getText().toString().equals(connexeion.getName()) &&
				// passwordField.getText().toString().equals(connexeion.getPassword()))
				User user = service.get(textField.getText(), passwordField.getText());
				if (user != null)

				{
					JOptionPane.showMessageDialog(null, " Bien Connecter");
					Menue menue=new Menue();
					menue.frame.setVisible(true);
					//frmGestionDePgormacie.setVisible(false);
					frmGestionDePgormacie.dispose();
			
				} else {
					JOptionPane.showMessageDialog(null, " your username or password is incorrect");
				}
			}
		});
		btConnexion.setBounds(167, 144, 116, 23);
		frmGestionDePgormacie.setLocationRelativeTo(null);
		frmGestionDePgormacie.getContentPane().add(btConnexion);
		
		JLabel lbHorloge = new JLabel("");
		lbHorloge.setHorizontalAlignment(SwingConstants.LEFT);
		SimpleDateFormat dh = new SimpleDateFormat("dd/MM/yyyy");
		   SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		        long  date = System.currentTimeMillis();
		        lbHorloge.setText(dh.format(date));
		        //lbHorloge.setText(df.format(date));
		     
		lbHorloge.setBounds(55, 175, 82, 26);
		frmGestionDePgormacie.getContentPane().add(lbHorloge);
		
		JLabel lbSeconde = new JLabel("");
		lbSeconde.setText(df.format(date));
		lbSeconde.setBounds(254, 178, 103, 20);
		frmGestionDePgormacie.getContentPane().add(lbSeconde);

	}
}
