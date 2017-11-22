package view;

import java.awt.Graphics;
import javax.swing.JButton;

import contract.IModel;

public class Bouton extends JButton {

	private static final long serialVersionUID = 1L;
	IModel model;
	
	public Bouton(IModel model) {
		this.setLayout(null);
		this.model = model;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}