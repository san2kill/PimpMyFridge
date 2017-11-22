package main;



import controller.ControllerFacade;
import model.ModelFacade;
import model.Serial;
import view.ViewFacade;


public  class main {

    public static void main(final String[] args) {
    	
    	Serial temp = new Serial();
    	
    	System.out.println(temp.getTemperature_Pelier());
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
        	 controller.start();
        	 
        	
    
        	 
    }

}
