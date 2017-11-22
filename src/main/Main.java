package main;



import controller.ControllerFacade;
import model.ModelFacade;

import java.util.concurrent.TimeUnit;

import view.ViewFacade;


public abstract class Main {

    public static void main(final String[] args) {
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());

       
        	 controller.start();
             
        	 
    }

}
