package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import implementations.Graph;
import prim.PrimsAlgorithm;

public class GUI {

	private JFrame frame;
	private JTextField vertexno;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Graph g;
	PrimsAlgorithm p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 394, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel main = new JPanel();
		main.setBackground(new Color(25, 25, 112));
		main.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(main);
		main.setLayout(null);

		JPanel primpanel = new JPanel();
		primpanel.setBackground(new Color(25, 25, 112));
		primpanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(primpanel);

		JPanel dijkstrapanel = new JPanel();
		dijkstrapanel.setBackground(new Color(25, 25, 112));
		dijkstrapanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(dijkstrapanel);

		JPanel viewpanel = new JPanel();
		viewpanel.setBackground(new Color(25, 25, 112));
		viewpanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(viewpanel);
		viewpanel.setLayout(null);
		viewpanel.setVisible(false);

		JPanel insertpanel = new JPanel();
		insertpanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(insertpanel);
		insertpanel.setBackground(new Color(25, 25, 112));
		insertpanel.setLayout(null);
		insertpanel.setVisible(false);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 37, 329, 231);
		viewpanel.add(textArea);

		JButton btnInsertGraph = new JButton("Insert Graph");
		btnInsertGraph.setBackground(new Color(192, 192, 192));
		btnInsertGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				insertpanel.setVisible(true);
				viewpanel.setVisible(false);
				primpanel.setVisible(false);
				dijkstrapanel.setVisible(false);
			}
		});
		btnInsertGraph.setBounds(95, 69, 176, 43);
		main.add(btnInsertGraph);

		JButton btnViewGraph = new JButton("View Graph");
		btnViewGraph.setBackground(new Color(192, 192, 192));
		btnViewGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewpanel.setVisible(true);
				main.setVisible(false);
				insertpanel.setVisible(false);
				primpanel.setVisible(false);
				dijkstrapanel.setVisible(false);
				textArea.setText(g.toString());
				System.out.println(g);
			}
		});
		btnViewGraph.setBounds(95, 123, 176, 37);
		main.add(btnViewGraph);

		JButton btnPrim = new JButton("Run Prim's Algorithm");
		btnPrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				insertpanel.setVisible(false);
				viewpanel.setVisible(false);
				primpanel.setVisible(true);
				dijkstrapanel.setVisible(false);

				p = new PrimsAlgorithm();
				p.Prims(Integer.parseInt(vertexno.getText()), g);

			}
		});
		btnPrim.setBackground(new Color(192, 192, 192));
		btnPrim.setBounds(95, 171, 176, 43);
		main.add(btnPrim);

		JButton btnRunDijkstrasAlgorithm = new JButton("Run Dijkstras Algorithm");
		btnRunDijkstrasAlgorithm.setBackground(new Color(192, 192, 192));
		btnRunDijkstrasAlgorithm.setBounds(95, 225, 176, 43);
		main.add(btnRunDijkstrasAlgorithm);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 37, 329, 231);
		viewpanel.add(scrollPane);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				insertpanel.setVisible(false);
				viewpanel.setVisible(false);
				primpanel.setVisible(false);
				dijkstrapanel.setVisible(false);
			}
		});
		btnBack_1.setBounds(23, 292, 89, 23);
		viewpanel.add(btnBack_1);

		JLabel lblEnterNoOf = new JLabel("Enter No of vertices :");
		lblEnterNoOf.setForeground(new Color(255, 255, 224));
		lblEnterNoOf.setBounds(27, 45, 137, 24);
		insertpanel.add(lblEnterNoOf);

		vertexno = new JTextField();
		vertexno.setBounds(174, 47, 44, 20);
		insertpanel.add(vertexno);
		vertexno.setColumns(10);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int start = Integer.parseInt(textField_1.getText());
				int end = Integer.parseInt(textField_2.getText());
				int edge = Integer.parseInt(textField_3.getText());
				g.addEdge(start, end, edge);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnInsert.setBackground(new Color(192, 192, 192));
		btnInsert.setBounds(27, 252, 89, 23);
		btnInsert.setEnabled(false);
		insertpanel.add(btnInsert);

		JButton btnStart = new JButton("New Graph");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vertexno.getText() != "")
					btnInsert.setEnabled(true);
				g = new Graph(Integer.parseInt(vertexno.getText()));

			}
		});
		btnStart.setBackground(new Color(192, 192, 192));
		btnStart.setBounds(153, 78, 99, 23);
		insertpanel.add(btnStart);

		textField_1 = new JTextField();
		textField_1.setBounds(156, 146, 44, 20);
		insertpanel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 177, 44, 20);
		insertpanel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(156, 208, 44, 20);
		insertpanel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblStartingVertex = new JLabel("Starting Vertex :");
		lblStartingVertex.setForeground(new Color(255, 255, 224));
		lblStartingVertex.setBounds(27, 149, 119, 14);
		insertpanel.add(lblStartingVertex);

		JLabel lblEndingVertex = new JLabel("Ending Vertex :");
		lblEndingVertex.setForeground(new Color(255, 255, 224));
		lblEndingVertex.setBounds(27, 180, 119, 14);
		insertpanel.add(lblEndingVertex);

		JLabel lblEdgeWeight = new JLabel("Edge weight :");
		lblEdgeWeight.setForeground(new Color(255, 255, 224));
		lblEdgeWeight.setBounds(27, 211, 119, 14);
		insertpanel.add(lblEdgeWeight);

		JButton btnBack = new JButton("Back ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				insertpanel.setVisible(false);
				viewpanel.setVisible(false);
				primpanel.setVisible(false);
				dijkstrapanel.setVisible(false);
			}
		});
		btnBack.setBackground(new Color(192, 192, 192));
		btnBack.setBounds(27, 286, 89, 23);
		insertpanel.add(btnBack);

		JSeparator separator = new JSeparator();
		separator.setBounds(27, 121, 327, 2);
		insertpanel.add(separator);

	}
}
