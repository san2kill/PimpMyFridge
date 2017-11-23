package main;

import java.util.concurrent.TimeUnit;

import contract.GlobalVar;
import controller.ControllerFacade;
import model.ModelFacade;
import model.Serial;
import view.ViewFacade;

public class main {

	public static void main(final String[] args) {

		Serial valeur = new Serial();
		

		final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
		controller.start();
		
		int a =1;
		while(a==1){
			System.out.println("tempBas=" + valeur.getTemperature_Pelier());
			System.out.println("tempHaut=" + valeur.getTemperature_dht22());
			System.out.println("humidity=" + valeur.getHumdidty());
			System.out.println("dewPoint=" + valeur.getDewPoint());



			//System.out.println("temperatureGlobalMain= "+ GlobalVar.GlobalVarTempFrigo);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
