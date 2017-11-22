package controller;

import contract.IController;
import contract.IModel;
import contract.IView;


public class ControllerFacade implements IController {

	private final IView  view;

	private final IModel model;

	public ControllerFacade(final IView view, final IModel model) {
		super();
		this.view = view;
		this.model = model;  
	}
	
	public void start() {
	this.view.InitView(model);
	}
	
	public IView getView() {
		return this.view;
	}

	public IModel getModel() {
		return this.model;
	}
    
}