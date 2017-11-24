package contract;

public interface IModel {

	public  double getTemperature_Pelier();
	public double  getHumidity();
	public double getDewPoint();
	public double getTemperature_dht22();
	public void addObserver(IView obs);
	public void notifyObserver(double temperature_Pelier);

}
