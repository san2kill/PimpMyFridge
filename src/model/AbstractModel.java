package model;

import java.util.ArrayList;

import contract.IModel;
import contract.IView;

public abstract class AbstractModel implements IModel {

	private ArrayList<IView> listObserver = new ArrayList<IView>();
	
	
	public void addObserver(IView obs) {
		// TODO Auto-generated method stub
		this.listObserver.add(obs);
	}

	@Override
	public void notifyObserver(double temperature_Pelier) {
		// TODO Auto-generated method stub
		for(IView obs : listObserver)
			obs.update(temperature_Pelier);
	}
	
	public void removeObserver(){
		listObserver = new ArrayList<IView>();
	}

}
