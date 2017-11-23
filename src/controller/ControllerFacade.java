package controller;

import java.util.Observer;

import contract.IController;
import contract.IModel;
import contract.IView;
import model.ModelFacade;
import view.ViewFacade;


public class ControllerFacade implements IController  {

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


	@Override
	public void addObserver(Observer obsController) {
		// TODO Auto-generated method stub
		
	}
  

} 