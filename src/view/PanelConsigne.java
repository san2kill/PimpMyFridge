package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import contract.GlobalVar;
import contract.IModel;
import contract.IView;
import model.Serial;

public class PanelConsigne extends JPanel implements IView {

	private static final long serialVersionUID = 1L;
	private Bouton bouttonConsigne;
	private JTextField txtFieldConsigne;
	private JLabel labelConsigne;
	static JLabel labelTempFrigo;
	static JLabel labelHumidity;
	private Bouton btGraph;
	static XYLineChart_AWT Graph;


	private PanelValConsigne pValConsigne;
	private JFrame frameValConsigne;

	Serial valeur = new Serial();

	IModel model;

	public PanelConsigne(IModel model) {
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.lightGray);

		this.bouttonConsigne = new Bouton(model);
		bouttonConsigne.setText("Confirmer");
		bouttonConsigne.setBounds(255, 115, 100, 50);
		bouttonConsigne.setEnabled(false);
		this.add(bouttonConsigne);

		this.txtFieldConsigne = new JTextField();
		txtFieldConsigne.setBounds(190, 125, 50, 30);
		txtFieldConsigne.setDocument(new JTextFieldLimit(2));
		this.add(txtFieldConsigne);

		this.labelConsigne = new JLabel("CONSIGNE : ");
		labelConsigne.setBounds(100, 125, 200, 30);
		labelConsigne.setForeground(Color.black);
		this.add(labelConsigne);

		/*this.btGraph = new Bouton(model);
		btGraph.setText("Graphique de la température");
		btGraph.setBounds(100, 220, 210, 60);
		this.add(btGraph);*/

		PanelConsigne.labelTempFrigo = new JLabel(valeur.getTemperature_Pelier()+"°C");
		labelTempFrigo.setBounds(530, 13, 200, 90);
		labelTempFrigo.setForeground(Color.cyan);
		Font font = new Font("Arial", Font.BOLD, 80);
		labelTempFrigo.setFont(font);
		this.add(labelTempFrigo);
		
		PanelConsigne.labelHumidity = new JLabel(GlobalVar.GlobalVarHumidity+"%");
		labelHumidity.setBounds(345, 190, 200, 90);
		labelHumidity.setForeground(Color.blue);
		labelHumidity.setFont(font);
		this.add(labelHumidity);


		txtFieldConsigne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (txtFieldConsigne.getText().trim().isEmpty() ) {
					bouttonConsigne.setEnabled(false);
				} else {
					bouttonConsigne.setEnabled(true);
				}
			}
		});

		bouttonConsigne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String a = txtFieldConsigne.getText().trim();

				GlobalVar.GlobalVarConsigne = Integer.parseInt(a); 

				pValConsigne = new PanelValConsigne(model);
				frameValConsigne = new JFrame("Valeur Consigne");
				frameValConsigne.setSize(700, 200);
				frameValConsigne.add(pValConsigne);
				frameValConsigne.setVisible(true);
			}

		});

		this.Graph = new XYLineChart_AWT("Temperature en fonction du temps", "Température en fonction du temps");
		Graph.pack();
		RefineryUtilities.centerFrameOnScreen(Graph);
		Graph.setVisible(true);

		


		this.model = model;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Arial", Font.BOLD, 40);
		g.setFont(font);
		g.setColor(Color.cyan);
		g.drawString("Température du Frigo = " , 70, 70);
		g.drawString("Humidité = " , 100, 250);

	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void InitView(IModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(double temperature_Pelier) {
		// TODO Auto-generated method stub

		PanelConsigne.labelTempFrigo.setText(temperature_Pelier+"°C");

	}



}
