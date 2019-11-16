package project;

import ocsf.client.AbstractClient;

public class GameClient extends AbstractClient {
	private String host;
	private int port;

	public GameClient() {
		super("localhost", 9300);
		host = "localhost";
		port = 9300;
	}

	public GameClient(String host, int port) {
		super(host, port);
		this.host = host;
		this.port = port;
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
