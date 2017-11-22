package view;

import java.awt.Graphics;
import javax.swing.JTextField;

import contract.IModel;

public class TextField extends JTextField {

	private static final long serialVersionUID = 1L;
	
	IModel model;

	public void TexteField(IModel model) {
		this.setLayout(null);
		
		this.model = model;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}