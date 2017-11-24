package view;


import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import contract.GlobalVar;
import contract.IModel;
import contract.IView;


public class ViewFacade implements IView {

	Frame frame;
	
	
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
		
		
		int a =1;
		while(a<1000){
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (GlobalVar.GlobalVarTempFrigo<=GlobalVar.GlobalVarPtRosee){
				Frame.getFrameWarning().setVisible(true);
			}else {
				Frame.getFrameWarning().setVisible(false);				
			}
			
			PanelConsigne.labelTempFrigo.setText(GlobalVar.GlobalVarTempFrigo+"°C");
			PanelConsigne.labelHumidity.setText(GlobalVar.GlobalVarHumidity+"%");
			
			XYLineChart_AWT.temperatureGraph.add(a,GlobalVar.GlobalVarTempFrigo);
			
			a=a+1;
		}
		
		
		
	}
	@Override
	public void update(double temperature_Pelier) {
		// TODO Auto-generated method stub
		
	}



}
