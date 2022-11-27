package interfaces;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import connexion.HttpConnexion;

import java.awt.Font;
import java.awt.KeyEventPostProcessor;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class Menue {

	JFrame frame;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textTotal;
	private JTextField textPayer;
	private JTextField textRest;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menue window = new Menue();
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
	public Menue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 778, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
		
		JLabel lbPrincipal = new JLabel("welcome to the pharmacy");
		lbPrincipal.setForeground(Color.BLUE);
		lbPrincipal.setBackground(Color.RED);
		lbPrincipal.setFont(new Font("Stencil", Font.PLAIN, 24));
		lbPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrincipal.setBounds(95, 11, 540, 48);
		frame.getContentPane().add(lbPrincipal);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(-10, 59, 762, 549);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbName = new JLabel("Nom ");
		lbName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbName.setBounds(28, 46, 94, 28);
		panel.add(lbName);
		
		textName = new JTextField();
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textName.setColumns(10);
		textName.setBounds(146, 46, 168, 45);
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textName);
		
		JLabel lbQuntite = new JLabel("Quantite");
		lbQuntite.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbQuntite.setBounds(28, 258, 126, 28);
		panel.add(lbQuntite);
		
		JLabel lbPrice = new JLabel("Prix");
		lbPrice.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbPrice.setBounds(28, 150, 69, 28);
		panel.add(lbPrice);
		
		textPrice = new JTextField();
		textPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textPrice.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		textPrice.setColumns(10);
		textPrice.setBounds(146, 146, 168, 45);
		panel.add(textPrice);
		
		final JSpinner textQuantite = new JSpinner();
		textQuantite.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		//textQuantite.setModel(new SpinnerDateModel(new Date(1669330800000L), null, null, Calendar.DAY_OF_YEAR));
		textQuantite.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textQuantite.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				 int PRIX=Integer.parseInt(textPrice.getText());
				 int qte=Integer.parseInt(textQuantite.getValue().toString());
				 int totale= qte*PRIX;
				 textTotal.setText(String.valueOf(totale)+" FCFA"); 
				 
				
			}
		});
		textQuantite.setBounds(146, 250, 168, 47);
		panel.add(textQuantite);
		
		JLabel lbelTotal = new JLabel("Total");
		lbelTotal.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbelTotal.setBounds(437, 58, 69, 28);
		panel.add(lbelTotal);
		
		JLabel lbelPayer = new JLabel("Payer");
		lbelPayer.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbelPayer.setBounds(437, 150, 69, 28);
		panel.add(lbelPayer);
		JLabel lbelReste = new JLabel("Reste");
		lbelReste.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbelReste.setBounds(437, 228, 69, 28);
		panel.add(lbelReste);
		textTotal = new JTextField();
		textTotal.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		textTotal.setForeground(new Color(255, 0, 0));
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setToolTipText("");
		
		textTotal.setColumns(10);
		textTotal.setBounds(522, 54, 191, 36);
		panel.add(textTotal);
		textPayer = new JTextField();
		textPayer.setHorizontalAlignment(SwingConstants.CENTER);
		textPayer.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		textPayer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int payer =Integer.parseInt(textPayer.getText().toString());
				int totale=Integer.parseInt(textTotal.getText().toString());
				int rest=payer-totale;
				textRest.setText(String.valueOf(rest)+" FCFA");
			}
		});
		textPayer.setColumns(10);
		textPayer.setBounds(522, 146, 191, 36);
		panel.add(textPayer);
		textRest = new JTextField();
		textRest.setForeground(new Color(0, 204, 0));
		textRest.setHorizontalAlignment(SwingConstants.CENTER);
		textRest.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textRest.setColumns(10);
		textRest.setBounds(522, 228, 191, 36);
		panel.add(textRest);
	    JButton btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		PreparedStatement post;
	    		HttpConnexion conn= new HttpConnexion();
	    		conn.connect(); 
	    			String query="insert into save_pharma(nom,prix,quantite,mt_total,payer,reste) values(?,?,?,?,?,?)";
	    			try {
					post= conn.getConnection().prepareStatement(query);
						post.setString(1, textName.getText());
						post.setString(2, textPrice.getText());
						post.setString(3, textQuantite.getValue().toString());
						post.setString(4, textTotal.getText());
						post.setString(5, textPayer.getText());
						post.setString(6, textRest.getText());
						post.executeUpdate();
						post.close();
						JOptionPane.showMessageDialog(null, textName.getText()+" a ete Ajouter avec succes\n Merci! ");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, " bdc jhb;svlc");
						e1.printStackTrace();
					}
	    	}
	    });
	    btnSave.setBounds(371, 334, 102, 36);
	    panel.add(btnSave);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(683, 348, -566, 163);
	    panel.add(scrollPane);
	    
	    table = new JTable();
	    table.setBackground(Color.ORANGE);
	    table.setForeground(Color.LIGHT_GRAY);
	    table.setFillsViewportHeight(true);
	    scrollPane.setViewportView(table);
	}
}
