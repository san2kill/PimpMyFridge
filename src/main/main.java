package main;



import controller.ControllerFacade;
import model.ModelFacade;


import view.ViewFacade;


public  class main {

    public static void main(final String[] args) {
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
        	 controller.start();
             
        	 
    }

}
