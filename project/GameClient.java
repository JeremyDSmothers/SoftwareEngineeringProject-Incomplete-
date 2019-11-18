package project;

import java.util.ArrayList;

import ocsf.client.AbstractClient;

public class GameClient extends AbstractClient {
	private String host;
	private int port;
	private ArrayList<String> countries;
	private ArrayList<String> cardOptions;
	private ArrayList<String> cardDescriptions;
	private ArrayList<String> cardImages;

	public GameClient() {
		super("localhost", 9300);
		host = "localhost";
		port = 9300;

		// instantiate arraylists as arraylists
		countries = new ArrayList<>();
		cardOptions = new ArrayList<>();
		cardDescriptions = new ArrayList<>();
		cardImages = new ArrayList<>();

		// instantiate content of arraylists
		setCountries();
		setCardTitles();
		setCardDescriptions();
		setCardImages();
	}

	public GameClient(String host, int port) {
		super(host, port);
		this.host = host;
		this.port = port;
	}

	private void setCardTitles() {
		cardOptions.add("Calvary Unit");
		cardOptions.add("Infantry Unit");
		cardOptions.add("Tank Unit");
		cardOptions.add("Medic Unit");
	}

	private void setCardDescriptions() {
		cardDescriptions.add("This is the description for the Calvary Unit");
		cardDescriptions.add("This is the description for the Infantry Unit");
		cardDescriptions.add("This is the description for the Tank Unit");
		cardDescriptions.add("This is the description for the Medic Unit");
	}

	private void setCardImages() {
		cardImages.add("calvaryUnit.jpg");
		cardImages.add("calvaryUnit.jpg");
		cardImages.add("calvaryUnit.jpg");
		cardImages.add("calvaryUnit.jpg");
	}

	private void setCountries() {
		countries.add("Kamchatka");
		countries.add("Yakutsk");
		countries.add("North Africa");
		countries.add("Egypt");
		countries.add("Congo");
		countries.add("East Africa");
		countries.add("South Africa");
		countries.add("Western Europe");
		countries.add("Southern Europe");
		countries.add("Northern Europe");
		countries.add("Great Britain");
		countries.add("Scandinavia");
		countries.add("Ukraine");
		countries.add("Middle East");
		countries.add("India");
		countries.add("Korea");
		countries.add("Indonesia");
		countries.add("New Guinea");
		countries.add("West Australia");
		countries.add("East Australia");
		countries.add("LotR");
		countries.add("China");
		countries.add("Afghanistan");
		countries.add("Siberia");
		countries.add("Irkutsk");
		countries.add("Mongolia");
		countries.add("Japan");
		countries.add("Alaska");
		countries.add("North Territory");
		countries.add("Ontario");
		countries.add("Quebec");
		countries.add("Greenland");
		countries.add("Iceland");
		countries.add("Alberta");
		countries.add("Western United States");
		countries.add("Eastern United States");
		countries.add("Florida");
		countries.add("Mexico");
		countries.add("Central America");
		countries.add("Venezuela");
		countries.add("Brazil");
		countries.add("Argentina");
	}

	public ArrayList<String> getCountries() {
		return countries;
	}

	public ArrayList<String> getCardOptions() {
		return cardOptions;
	}

	public ArrayList<String> getCardDescriptions() {
		return cardDescriptions;
	}

	public ArrayList<String> getCardImages() {
		return cardImages;
	}

	@Override
	protected void handleMessageFromServer(Object arg0) {
		System.out.println("Got a msg from server: " + arg0.toString());
	}

	public void connectionEstablished() {
		System.out.println("Connection Established");
	}

	public void connectionException(Throwable exception) {
		System.out.println("Connection Exception Occured");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	}
}
