package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

import contract.GlobalVar;
import contract.IModel;

public class PanelValConsigne extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel labelConsigne;
	
	IModel model;


	public PanelValConsigne(IModel model) {
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);
		this.setBackground(Color.cyan);

		/*this.labelConsigne = new JLabel(""+ GlobalVar.GlobalVarConsigne);
		labelConsigne.setBounds(100, 100, 200, 30);
		labelConsigne.setForeground(Color.black);
		this.add(labelConsigne);*/
		
		this.model = model;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Arial", Font.BOLD, 40);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Valeur de la consigne : "+ GlobalVar.GlobalVarConsigne, 100, 50);
	}

}
