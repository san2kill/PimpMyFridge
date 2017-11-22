package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import contract.IModel;

public class PanelWarning extends JPanel {

	private static final long serialVersionUID = 1L;
	//private JLabel labelWarningPt;

	IModel model;
	
	public PanelWarning(IModel model) {
		this.setLayout(null);
		this.setBounds(0, 0, 800, 400);
		this.setBackground(Color.red);

		/*this.labelWarningPt = new JLabel("Valeur du point de Rosee : ");
		labelWarningPt.setBounds(100, 100, 200, 30);
		labelWarningPt.setForeground(Color.black);
		this.add(labelWarningPt);*/
		
		this.model = model;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Arial", Font.BOLD, 40);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("ATTENTION RISQUE DE CONDENSATION", 100, 50);
	}

}
