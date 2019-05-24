package projekti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import java.awt.TextField;
import java.awt.List;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;

public class frmMain extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
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
	public frmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 390);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnKryefaqja = new JMenu("Kryefaqja");
		menuBar.add(mnKryefaqja);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnKryefaqja.add(mntmNewMenuItem);
		
		JMenu mnLinjat = new JMenu("Linjat");
		menuBar.add(mnLinjat);
		
		JMenu mnRezervoni = new JMenu("Rezervoni");
		menuBar.add(mnRezervoni);
		
		JMenu mnNdihme = new JMenu("Ndihme");
		menuBar.add(mnNdihme);
		
		JMenu mnNewMenu = new JMenu("Gjuha");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmShqip = new JMenuItem("Shqip");
		mnNewMenu.add(mntmShqip);
		
		JMenuItem mntmAnglisht = new JMenuItem("Anglisht");
		mnNewMenu.add(mntmAnglisht);
		
		JMenu mnKycuni = new JMenu("Kycuni");
		menuBar.add(mnKycuni);
		
		JMenuItem mntmLidhu = new JMenuItem("Lidhu");
		mnKycuni.add(mntmLidhu);
		
		JMenuItem mntmRegjistrohu = new JMenuItem("Regjistrohu");
		mnKycuni.add(mntmRegjistrohu);
		getContentPane().setLayout(null);
		
		JLabel lblNisja = new JLabel("Nisja");
		lblNisja.setBounds(37, 40, 64, 28);
		getContentPane().add(lblNisja);
		
		textField = new JTextField();
		textField.setBounds(145, 39, 115, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDestinacioni = new JLabel("Destinacioni");
		lblDestinacioni.setBounds(37, 79, 85, 36);
		getContentPane().add(lblDestinacioni);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 81, 115, 28);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnKerko = new JButton("Kerko");
		btnKerko.setBounds(290, 64, 89, 23);
		getContentPane().add(btnKerko);
		
		JLabel lblKomentesygjerimeAnkesa = new JLabel("Komente,sygjerime, ankesa");
		lblKomentesygjerimeAnkesa.setBounds(10, 211, 217, 14);
		getContentPane().add(lblKomentesygjerimeAnkesa);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(10, 257, 397, 63);
		getContentPane().add(textField_2);
		
		Button button = new Button("Dergo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(413, 231, 70, 22);
		getContentPane().add(button);
		
		Button button_1 = new Button("Fshij");
		button_1.setBounds(413, 264, 70, 22);
		getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("Emri:");
		lblNewLabel.setBounds(10, 236, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(37, 231, 139, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
