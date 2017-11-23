package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;


public class Serial implements SerialPortEventListener {
	private double Temperature_Pelier;
	private double Temperature_dht22;
	private double Humdidty;
	private double dewPoint;
	SerialPort serialPort;
	private static final String PORT_SERIAL[] = { "COM5", // Windows
	};

	private BufferedReader input;
	private OutputStream output;
	private static final int TIME_OUT = 2000;// la valeur de temporisation pour la connexion avec l'orifice
	private static final int DATA_RATE = 9600;
	//recherche du port série connecté à l'arduino avec la methode initialize()
	
	
	public Serial(){
		//Serial main = new Serial();
		this.initialize();
		/*Thread t = new Thread() {
			public void run() {
				// the following line will keep this app alive for 1000 seconds,
				// waiting for events to occur and responding to them (printing
				// incoming messages to console).
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();*/
		System.out.println(" Started ");
    	System.out.println(this.getTemperature_Pelier());
		
	}
	
	
	
	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//recherchez une instance du port série définie dans PORT_SERIAL.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_SERIAL) {
				// obtient uniquement le port série
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println(" Could not find COM port. ");
			return;
		}

		try {
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
			//ouvre les flux d'entrée et de sortie
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			serialPort.addEventListener(this);
			/**renvoie la valeur  si l'ouverture des flux est réussie ou non
			 * 
			 */
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = null;
				if (input.ready()) {
					inputLine = input.readLine();
					String[] inputLineDecoupage = inputLine.split(";");

					//String[] chunks = inputLine.split(";");

					System.out.println(inputLine);
					System.out.println(inputLineDecoupage[0]);
					System.out.println(inputLineDecoupage[1]);
					System.out.println(inputLineDecoupage[2]);
					System.out.println(inputLineDecoupage[3]);
					setTemperature_Pelier(Double.parseDouble(inputLineDecoupage[0]));
					setTemperature_dht22(Double.parseDouble(inputLineDecoupage[0]));
					setHumdidty(Double.parseDouble(inputLineDecoupage[0]));
					setDewPoint(Double.parseDouble(inputLineDecoupage[0]));

					System.out.println("temperature= "+ getTemperature_Pelier());
					
					//System.out.println(chunks[0] + " \t " + chunks[1] + " \t " + chunks[2] + " \t ");
				}

			} catch (Exception e) {
				System.err.println(e.toString()+"ERROR");
			}
		}
		// Ignore all the other eventTypes, but you should consider the other
		// ones.
	}

	/*public static void main(String[] args) throws Exception {
		Serial main = new Serial();
		main.initialize();
		Thread t = new Thread() {
			public void run() {
				// the following line will keep this app alive for 1000 seconds,
				// waiting for events to occur and responding to them (printing
				// incoming messages to console).
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();
		System.out.println(" Started ");
	}*/

	public double getTemperature_Pelier() {
		return Temperature_Pelier;
	}

	public void setTemperature_Pelier(double temperature_Pelier) {
		Temperature_Pelier = temperature_Pelier;
	}

	public double getTemperature_dht22() {
		return Temperature_dht22;
	}

	public void setTemperature_dht22(double temperature_dht22) {
		Temperature_dht22 = temperature_dht22;
	}

	public double getHumdidty() {
		return Humdidty;
	}

	public void setHumdidty(double humdidty) {
		Humdidty = humdidty;
	}

	public double getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(double dewPoint) {
		this.dewPoint = dewPoint;
	}

}