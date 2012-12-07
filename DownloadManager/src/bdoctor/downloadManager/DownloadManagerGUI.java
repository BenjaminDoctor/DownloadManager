package bdoctor.downloadManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;



public class DownloadManagerGUI extends JFrame {

	downloadManager app = new downloadManager();
	
	private JPanel contentPane;
	private JTextField txtSource;
	private JTextField txtDestination;
	private JTextArea txtQueue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DownloadManagerGUI frame = new DownloadManagerGUI();
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
	public DownloadManagerGUI() {
		setTitle("Download Manager ver. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSource = new JTextField();
		txtSource.setBounds(81, 27, 222, 20);
		contentPane.add(txtSource);
		txtSource.setColumns(10);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(25, 27, 46, 20);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(361, 27, 74, 20);
		contentPane.add(lblDestination);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(445, 27, 222, 20);
		contentPane.add(txtDestination);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 107, 642, 277);
		contentPane.add(scrollPane);
		
		txtQueue = new JTextArea();
		txtQueue.setEditable(false);
		scrollPane.setViewportView(txtQueue);
		
		JButton btnAddDownload = new JButton("Add Download");
		btnAddDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String source = txtSource.getText();
				String dest = txtDestination.getText();
				
				txtSource.setText("");
				txtDestination.setText("");
								
				app.createDownload(source, dest);
				setQueue(app.getQueue());
				
			}
		});
		btnAddDownload.setBounds(81, 58, 111, 23);
		contentPane.add(btnAddDownload);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.downloadQueue();
			}
		});
		btnDownload.setBounds(212, 58, 91, 23);
		contentPane.add(btnDownload);
	}
	
	public void setQueue(String s){
		txtQueue.setText(s);
	}
}
