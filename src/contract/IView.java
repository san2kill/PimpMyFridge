package contract;

import contract.IModel;


public interface IView {

        
        void displayMessage(String message);

    	void InitView(IModel model);

    	void update(IModel model);
    }

