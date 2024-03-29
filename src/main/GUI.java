package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.SwingConstants;

import dijkstra.DijkstrasAlgorithm;
import implementations.Graph;
import implementations.MinHeap.HeapNode;
import prim.PrimsAlgorithm;

public class GUI {

	private JFrame frame;
	private JTextField vertexno;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Graph g;
	PrimsAlgorithm p;
	DijkstrasAlgorithm d;
	private JTextField startvertex;

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

		JPanel dijkstrapanel = new JPanel();
		dijkstrapanel.setBackground(new Color(25, 25, 112));
		dijkstrapanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(dijkstrapanel);
		dijkstrapanel.setLayout(null);

		JPanel insertpanel = new JPanel();
		insertpanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(insertpanel);
		insertpanel.setBackground(new Color(25, 25, 112));
		insertpanel.setLayout(null);
		insertpanel.setVisible(false);

		JPanel primpanel = new JPanel();
		primpanel.setBackground(new Color(25, 25, 112));
		primpanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(primpanel);
		primpanel.setLayout(null);

		JPanel viewpanel = new JPanel();
		viewpanel.setBackground(new Color(25, 25, 112));
		viewpanel.setBounds(0, 0, 378, 326);
		frame.getContentPane().add(viewpanel);
		viewpanel.setLayout(null);
		viewpanel.setVisible(false);

		JButton button = new JButton("Back");
		button.setBounds(24, 292, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				insertpanel.setVisible(false);
				viewpanel.setVisible(false);
				primpanel.setVisible(false);
				dijkstrapanel.setVisible(false);
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		dijkstrapanel.add(button);

		JTextArea dijkstratext = new JTextArea();
		dijkstratext.setBounds(24, 54, 326, 227);
		dijkstrapanel.add(dijkstratext);

		JLabel lblDijkstrasAlgorithm = new JLabel("Dijkstra's Algorithm");
		lblDijkstrasAlgorithm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDijkstrasAlgorithm.setHorizontalAlignment(SwingConstants.CENTER);
		lblDijkstrasAlgorithm.setForeground(new Color(255, 255, 224));
		lblDijkstrasAlgorithm.setBounds(112, 11, 166, 32);
		dijkstrapanel.add(lblDijkstrasAlgorithm);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 37, 329, 231);
		viewpanel.add(textArea);

		JLabel lblMinimumSpanningTree = new JLabel("Minimum Spanning Tree :");
		lblMinimumSpanningTree.setForeground(new Color(255, 255, 224));
		lblMinimumSpanningTree.setBounds(24, 67, 149, 14);
		primpanel.add(lblMinimumSpanningTree);

		JLabel MSTlabel = new JLabel("");
		MSTlabel.setForeground(new Color(255, 255, 224));
		MSTlabel.setBounds(183, 67, 185, 14);
		primpanel.add(MSTlabel);

		JLabel lblWeightOfThe = new JLabel("Weight of the tree :");
		lblWeightOfThe.setForeground(new Color(255, 255, 224));
		lblWeightOfThe.setBounds(24, 127, 149, 14);
		primpanel.add(lblWeightOfThe);

		JLabel weightlabel = new JLabel("");
		weightlabel.setForeground(new Color(255, 255, 224));
		weightlabel.setBounds(183, 127, 131, 14);
		primpanel.add(weightlabel);

		JLabel lblStarting = new JLabel("Start vertex :");
		lblStarting.setForeground(new Color(255, 255, 224));
		lblStarting.setBounds(27, 60, 119, 14);
		insertpanel.add(lblStarting);

		startvertex = new JTextField();
		startvertex.setColumns(10);
		startvertex.setBounds(156, 57, 44, 20);
		insertpanel.add(startvertex);

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
				p.Prims(Integer.parseInt(vertexno.getText()), Integer.parseInt(startvertex.getText()), g);
				weightlabel.setText(Integer.toString(p.getweight()));
				/**
				 * String mst[] = p.getMST(); String str = " "; for (int i = 0; i < mst.length;
				 * i++) { str = str + " " + mst[i]; }
				 **/
				MSTlabel.setText(p.getMST());
			}
		});
		btnPrim.setBackground(new Color(192, 192, 192));
		btnPrim.setBounds(95, 171, 176, 43);
		main.add(btnPrim);

		JButton btnRunDijkstrasAlgorithm = new JButton("Run Dijkstras Algorithm");
		btnRunDijkstrasAlgorithm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				insertpanel.setVisible(false);
				viewpanel.setVisible(false);
				primpanel.setVisible(false);
				dijkstrapanel.setVisible(true);
				dijkstratext.setText("");

				d = new DijkstrasAlgorithm();
				d.Dijkstra(Integer.parseInt(vertexno.getText()), Integer.parseInt(startvertex.getText()), g);
				HeapNode mst[] = d.getSHP();

				for (int i = 0; i < Integer.parseInt(vertexno.getText()); i++) {
					String str = d.ShortestPath(i, Integer.parseInt(startvertex.getText()));
					if (str.compareTo(Integer.toString(i)) != 0 || str.compareTo(startvertex.getText()) == 0)
						dijkstratext.append(
								"Path of vertex " + i + " is : " + str + "\t" + "Distance is : " + mst[i].key + "\n");
					else {
						dijkstratext.append("Path of vertex " + i + " is : No Path !" + "\n");
					}
				}
			}
		});
		btnRunDijkstrasAlgorithm.setBackground(new Color(192, 192, 192));
		btnRunDijkstrasAlgorithm.setBounds(95, 225, 176, 43);
		main.add(btnRunDijkstrasAlgorithm);

		JLabel lblEnterNoOf = new JLabel("Enter No of vertices :");
		lblEnterNoOf.setForeground(new Color(255, 255, 224));
		lblEnterNoOf.setBounds(27, 25, 137, 24);
		insertpanel.add(lblEnterNoOf);

		vertexno = new JTextField();
		vertexno.setBounds(156, 27, 44, 20);
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
		btnStart.setBounds(27, 87, 99, 23);
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

		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
				insertpanel.setVisible(false);
				viewpanel.setVisible(false);
				primpanel.setVisible(false);
				dijkstrapanel.setVisible(false);
			}
		});
		btnBack_2.setBackground(new Color(192, 192, 192));
		btnBack_2.setBounds(24, 266, 89, 23);
		primpanel.add(btnBack_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 37, 329, 231);
		viewpanel.add(scrollPane);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setBackground(new Color(192, 192, 192));
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

	}
}
