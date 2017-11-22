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

	SerialPort serialPort;
	private static final String PORT_SERIAL[] = { "COM5", // Windows
	};

	private BufferedReader input;
	private OutputStream output;
	private static final int TIME_OUT = 2000;// la valeur de temporisation pour la connexion avec l'orifice
	private static final int DATA_RATE = 9600;
	//recherche du port série connecté à l'arduino avec la methode initialize()
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

					String[] chunks = inputLine.split(" , ");

					System.out.println(inputLine);
					System.out.println(chunks[0] + " \t " + chunks[1] + " \t " + chunks[2] + " \t ");
				}

			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	
	}

/*	public static void main(String[] args) throws Exception {
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
}