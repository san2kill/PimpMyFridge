package model;


import java.util.ArrayList;

import contract.IModel;
import contract.IView;


public class ModelFacade implements IModel {
	
    public ModelFacade() {
        super();
    }

	@Override
	public double getTemperature_Pelier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHumidity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDewPoint() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTemperature_dht22() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private ArrayList<IView> listObserver = new ArrayList<IView>();
	

	@Override
	public void addObserver(IView obs) {
		// TODO Auto-generated method stub
		this.listObserver.add(obs);
	}

	public void notifyObserver (double temperature_Pelier){
		for (IView obs : listObserver)
			obs.update(temperature_Pelier);
	}
	
	public void removeObserver(){
		listObserver = new ArrayList<IView>();
	}
}
