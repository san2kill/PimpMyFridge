package contract;

import contract.IModel;


public interface IView {

        
        void displayMessage(String message);

    	void InitView(IModel model);

    	public void update(double temperature_Pelier);
    }

