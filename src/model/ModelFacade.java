package model;


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

	@Override
	public void addObserver(IView view) {
		// TODO Auto-generated method stub
		
	}


}
