package view;


import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import contract.GlobalVar;
import contract.IModel;


public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConsigne pConsigne;
	private JFrame frameConsigne;


	private JLabel labelTempFrigo;
	
	private PanelWarning pWarning;
	private static JFrame frameWarning;
	
	//private PanelConsigne panMenu;

	IModel model;
	private PanelConsigne panMenu;
	
	public Frame(IModel model) {

		/*this.pConsigne = new PanelConsigne(model);
		frameConsigne = new JFrame("MENU");
		frameConsigne.setSize(750, 350);
		frameConsigne.add(pConsigne);
		frameConsigne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameConsigne.setVisible(true);*/


		this.pWarning = new PanelWarning(model);
		setFrameWarning(new JFrame("WARNING"));
		getFrameWarning().setSize(1000, 150);
		getFrameWarning().add(pWarning);
		
		
		this.model = model;
		this.panMenu = new PanelConsigne(model);
		this.setSize(750, 350);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panMenu);
	
		this.setVisible(true);
		
		
		
		
	}

	public static JFrame getFrameWarning() {
		return frameWarning;
	}

	public void setFrameWarning(JFrame frameWarning) {
		Frame.frameWarning = frameWarning;
	}

}
