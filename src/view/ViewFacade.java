package view;


import java.awt.Container;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import contract.GlobalVar;
import contract.IModel;
import contract.IView;


public class ViewFacade implements IView {

	Frame frame;
	Container cp;
	
	public ViewFacade() {
		super();
	}
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	@Override
	public void InitView(IModel model) {
		// TODO Auto-generated method stub
		
		this.frame = new Frame(model);
		
		if (GlobalVar.GlobalVarPtRosee<15){
			Frame.getFrameWarning().setVisible(true);
		}
		
		/*int a =1;
		while(a<1000){
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			PanelConsigne.labelTempFrigo.setText(""+GlobalVar.GlobalVarTempFrigo+"°C");
			a=a+1;
		}*/
		
		
		
	}
	@Override
	public void update(IModel model) {
		// TODO Auto-generated method stub
		
	}



}
