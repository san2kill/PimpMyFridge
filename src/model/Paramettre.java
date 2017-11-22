package model;

public class Paramettre {

	private Double Temperature;
	private Boolean Condensation;
	private Double Humidity;
	
	
	

	public Paramettre(double temperature, double Humidity) {
		this.setHumidity(Humidity);
		this.Temperature=Temperature;
		this.Condensation=Condensation;
		
		Paramettre condensation = new Paramettre(20.0,25.0);
		System.out.println(condensation.equals(Condensation));
	}



	public Double getTemperature() {
		return Temperature;
	}


	public void setTemperature(Double temperature) {
		Temperature = temperature;
	}


	public Boolean getCondensation() {
		return Condensation;
	}


	public void setCondensation(Boolean condensation) {
		Condensation = condensation;
	}



	public Double getHumidity() {
		return Humidity;
	}



	public void setHumidity(Double humidity) {
		Humidity = humidity;
	}
}
	
