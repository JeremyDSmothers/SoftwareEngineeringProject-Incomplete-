package project.Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import project.Country;

public class GamePanel extends JPanel {
	private ArrayList<Country> countries;
	private ArrayList<CardPanel> deck;

	// country click
	private JLabel leftPanelNameLabel;
	private JLabel leftPanelOwnedByLabel;
	private JLabel leftPanelTroopsLabel;
	private JLabel SouthPanelTitleLabel;
	private JLabel SouthPanelMsgLabel;

	// card click
	private JButton cardInfoButton;
	private JLabel cardTitle;
	private JLabel cardDescription;

	private GameControl gc;

	public GamePanel(GameControl gc) {
		this.gc = gc;
		setLayout(new BorderLayout(0, 0));
		countries = new ArrayList<>();
		deck = new ArrayList<>();

		JPanel leftInfoPanel = new JPanel();
		add(leftInfoPanel, BorderLayout.WEST);
		leftInfoPanel.setLayout(
				new FormLayout(new ColumnSpec[] { FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("160px"), },
						new RowSpec[] { FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("1px"),
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
								FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
								FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));
		leftInfoPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

		Component leftStrut = Box.createHorizontalStrut(160);
		leftInfoPanel.add(leftStrut, "2, 2, left, fill");

		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leftInfoPanel.add(lblName, "2, 4, center, default");

		leftPanelNameLabel = new JLabel("0");
		leftInfoPanel.add(leftPanelNameLabel, "2, 6, center, default");

		JLabel lblOwnedBy = new JLabel("Owned by: ");
		lblOwnedBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leftInfoPanel.add(lblOwnedBy, "2, 10, center, default");

		leftPanelOwnedByLabel = new JLabel("0");
		leftInfoPanel.add(leftPanelOwnedByLabel, "2, 12, center, default");

		JLabel lblTroops = new JLabel("Troops: ");
		lblTroops.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leftInfoPanel.add(lblTroops, "2, 16, center, default");

		leftPanelTroopsLabel = new JLabel("0");
		leftInfoPanel.add(leftPanelTroopsLabel, "2, 18, center, default");

		JButton btnBack = new JButton("Back");
		leftInfoPanel.add(btnBack, "2, 64");
		btnBack.addActionListener(gc);

		JPanel rightInfoPanel = new JPanel();
		add(rightInfoPanel, BorderLayout.EAST);
		rightInfoPanel.setLayout(new GridLayout(2, 1, 10, 0));
		rightInfoPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

		JPanel cardGrid = new JPanel();
		cardGrid.setLayout(new GridLayout(2, 3, 0, 0));
		rightInfoPanel.add(cardGrid);

		CardPanel card1 = new CardPanel(gc);
		card1.setSize(75, 90);
		card1.setCardTitle("card1");
		CardPanel card2 = new CardPanel(gc);
		card2.setSize(75, 90);
		card2.setCardTitle("card2");
		CardPanel card3 = new CardPanel(gc);
		card3.setSize(75, 90);
		card3.setCardTitle("card3");
		CardPanel card4 = new CardPanel(gc);
		card4.setSize(75, 90);
		CardPanel card5 = new CardPanel(gc);
		card5.setSize(75, 90);
		CardPanel card6 = new CardPanel(gc);
		card6.setSize(75, 90);
		cardGrid.add(card1);
		cardGrid.add(card2);
		cardGrid.add(card3);
		cardGrid.add(card4);
		cardGrid.add(card5);
		cardGrid.add(card6);
		deck.add(card1);
		deck.add(card2);
		deck.add(card3);
		deck.add(card4);
		deck.add(card5);
		deck.add(card6);
		cardGrid.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

		JPanel cardInfoPanel = new JPanel();
		cardInfoPanel.setBackground(Color.RED);
		rightInfoPanel.add(cardInfoPanel, BorderLayout.NORTH);
		cardInfoPanel.setLayout(new BorderLayout(0, 0));

		cardInfoButton = new JButton("");
		cardInfoButton.setHorizontalAlignment(SwingConstants.RIGHT);
		cardInfoButton.setVerticalAlignment(SwingConstants.TOP);
		cardInfoButton.addActionListener(gc);
		cardInfoPanel.add(cardInfoButton, BorderLayout.CENTER);

		cardTitle = new JLabel("Card Title");
		cardTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		cardInfoPanel.add(cardTitle, BorderLayout.NORTH);

		cardDescription = new JLabel(
				"<html>Card Description - This area<br>\r\nwill be used to explain,<br>\r\nin detail, what the card is used for\r\n<br>and how it<br>\r\ncan be applied to the user.<br>\r\nYou can use html to apply styling<br>\r\nand implement line breaks using<br>\r\nthe \"br\" tag (sub \" for <>)\r\n");
		cardDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cardDescription.setHorizontalAlignment(SwingConstants.CENTER);
		cardInfoPanel.add(cardDescription, BorderLayout.SOUTH);

		JPanel southInfoPanel = new JPanel();
		add(southInfoPanel, BorderLayout.SOUTH);
		southInfoPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

		SouthPanelTitleLabel = new JLabel("SouthPanelLabel: ");
		SouthPanelTitleLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		southInfoPanel.add(SouthPanelTitleLabel);

		SouthPanelMsgLabel = new JLabel("New label");
		SouthPanelMsgLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		southInfoPanel.add(SouthPanelMsgLabel);

		JPanel boardPanel = new JPanel();
		add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(null);
		boardPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

		instantiateCountryList(boardPanel);
	}

	public ArrayList<CardPanel> getDeck() {
		return deck;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	// card click
	public JButton getCardInfoButton() {
		return cardInfoButton;
	}

	public JLabel getCardTitle() {
		return cardTitle;
	}

	public JLabel getCardDescription() {
		return cardDescription;
	}

	// country click
	public JLabel getLeftPanelNameLabel() {
		return leftPanelNameLabel;
	}

	public JLabel getLeftPanelOwnedByLabel() {
		return leftPanelOwnedByLabel;
	}

	public JLabel getLeftPanelTroopsLabel() {
		return leftPanelTroopsLabel;
	}

	public JLabel getSouthPanelTitleLabel() {
		return SouthPanelTitleLabel;
	}

	public JLabel getSouthPanelMsgLabel() {
		return SouthPanelMsgLabel;
	}

	// setup
	private void instantiateCountryList(JPanel boardPanel) {
		JButton btnKamchatka = new JButton("Kamchatka");
		btnKamchatka.setBounds(1219, 34, 108, 271);
		btnKamchatka.addActionListener(gc);
		boardPanel.add(btnKamchatka);
		Country Kamchatka = new Country(btnKamchatka);

		JButton btnYakutsk = new JButton("Yakutsk");
		btnYakutsk.setBounds(1051, 34, 171, 83);
		btnYakutsk.addActionListener(gc);
		boardPanel.add(btnYakutsk);
		Country Yakutsk = new Country(btnYakutsk);

		JButton btnNorthAfrica = new JButton("North Africa");
		btnNorthAfrica.setBounds(546, 521, 176, 106);
		btnNorthAfrica.addActionListener(gc);
		boardPanel.add(btnNorthAfrica);
		Country NorthAfrica = new Country(btnNorthAfrica);

		JButton btnEgypt = new JButton("Egypt");
		btnEgypt.setBounds(722, 540, 202, 87);
		btnEgypt.addActionListener(gc);
		boardPanel.add(btnEgypt);
		Country Egypt = new Country(btnEgypt);

		JButton btnCongo = new JButton("Congo");
		btnCongo.setBounds(647, 628, 172, 117);
		btnCongo.addActionListener(gc);
		boardPanel.add(btnCongo);
		Country Congo = new Country(btnCongo);

		JButton btnEastAfrica = new JButton("East Africa");
		btnEastAfrica.setBounds(822, 628, 102, 117);
		btnEastAfrica.addActionListener(gc);
		boardPanel.add(btnEastAfrica);
		Country EastAfrica = new Country(btnEastAfrica);

		JButton btnSouthAfrica = new JButton("South Africa");
		btnSouthAfrica.setBounds(696, 746, 202, 97);
		btnSouthAfrica.addActionListener(gc);
		boardPanel.add(btnSouthAfrica);
		Country SouthAfrica = new Country(btnSouthAfrica);

		JButton btnWesternEurope = new JButton("Western Europe");
		btnWesternEurope.setBounds(558, 420, 130, 65);
		btnWesternEurope.addActionListener(gc);
		boardPanel.add(btnWesternEurope);
		Country WesternEurope = new Country(btnWesternEurope);

		JButton btnSouthernEurope = new JButton("Southern Europe");
		btnSouthernEurope.setBounds(687, 440, 132, 45);
		btnSouthernEurope.addActionListener(gc);
		boardPanel.add(btnSouthernEurope);
		Country SouthernEurope = new Country(btnSouthernEurope);

		JButton btnNorthernEurope = new JButton("Northern Europe");
		btnNorthernEurope.setBounds(687, 392, 132, 45);
		btnNorthernEurope.addActionListener(gc);
		boardPanel.add(btnNorthernEurope);
		Country NorthernEurope = new Country(btnNorthernEurope);

		JButton btnGreatBritain = new JButton("Great Britain");
		btnGreatBritain.setBounds(596, 296, 73, 83);
		btnGreatBritain.addActionListener(gc);
		boardPanel.add(btnGreatBritain);
		Country GreatBritain = new Country(btnGreatBritain);

		JButton btnScandinavia = new JButton("Scandinavia");
		btnScandinavia.setBounds(687, 201, 102, 83);
		btnScandinavia.addActionListener(gc);
		boardPanel.add(btnScandinavia);
		Country Scandinavia = new Country(btnScandinavia);

		JButton btnUkraine = new JButton("Ukraine");
		btnUkraine.setBounds(790, 230, 134, 160);
		btnUkraine.addActionListener(gc);
		boardPanel.add(btnUkraine);
		Country Ukraine = new Country(btnUkraine);

		JButton btnMiddleEast = new JButton("Middle East");
		btnMiddleEast.setBounds(822, 390, 97, 148);
		btnMiddleEast.addActionListener(gc);
		boardPanel.add(btnMiddleEast);
		Country MiddleEast = new Country(btnMiddleEast);

		JButton btnIndia = new JButton("India");
		btnIndia.setBounds(926, 482, 162, 45);
		btnIndia.addActionListener(gc);
		boardPanel.add(btnIndia);
		Country India = new Country(btnIndia);

		JButton btnKorea = new JButton("Korea");
		btnKorea.setBounds(1088, 482, 73, 75);
		btnKorea.addActionListener(gc);
		boardPanel.add(btnKorea);
		Country Korea = new Country(btnKorea);

		JButton btnIndonesia = new JButton("Indonesia");
		btnIndonesia.setBounds(1070, 605, 130, 36);
		btnIndonesia.addActionListener(gc);
		boardPanel.add(btnIndonesia);
		Country Indonesia = new Country(btnIndonesia);

		JButton btnNewGuinea = new JButton("New Guinea");
		btnNewGuinea.setBounds(1259, 616, 108, 36);
		btnNewGuinea.addActionListener(gc);
		boardPanel.add(btnNewGuinea);
		Country NewGuinea = new Country(btnNewGuinea);

		JButton btnWestAustralia = new JButton("West Australia");
		btnWestAustralia.setBounds(1092, 674, 130, 137);
		btnWestAustralia.addActionListener(gc);
		boardPanel.add(btnWestAustralia);
		Country WestAustralia = new Country(btnWestAustralia);

		JButton btnEastAustralia = new JButton("East Australia");
		btnEastAustralia.setBounds(1219, 674, 122, 137);
		btnEastAustralia.addActionListener(gc);
		boardPanel.add(btnEastAustralia);
		Country EastAustralia = new Country(btnEastAustralia);

		JButton btnLotR = new JButton("LotR");
		btnLotR.setBounds(1352, 779, 57, 75);
		btnLotR.addActionListener(gc);
		boardPanel.add(btnLotR);
		Country LotR = new Country(btnLotR);

		JButton btnChina = new JButton("China");
		btnChina.setBounds(1031, 372, 154, 106);
		btnChina.addActionListener(gc);
		boardPanel.add(btnChina);
		Country China = new Country(btnChina);

		JButton btnAfghanistan = new JButton("Afghanistan");
		btnAfghanistan.setBounds(924, 307, 104, 162);
		btnAfghanistan.addActionListener(gc);
		boardPanel.add(btnAfghanistan);
		Country Afghanistan = new Country(btnAfghanistan);

		JButton btnSiberia = new JButton("Siberia");
		btnSiberia.setBounds(942, 34, 97, 271);
		btnSiberia.addActionListener(gc);
		boardPanel.add(btnSiberia);
		Country Siberia = new Country(btnSiberia);

		JButton btnIrkutsk = new JButton("Irkutsk");
		btnIrkutsk.setBounds(1040, 121, 176, 117);
		btnIrkutsk.addActionListener(gc);
		boardPanel.add(btnIrkutsk);
		Country Irkutsk = new Country(btnIrkutsk);

		JButton btnMongolia = new JButton("Mongolia");
		btnMongolia.setBounds(1036, 252, 171, 117);
		btnMongolia.addActionListener(gc);
		boardPanel.add(btnMongolia);
		Country Mongolia = new Country(btnMongolia);

		JButton btnJapan = new JButton("Japan");
		btnJapan.setBounds(1230, 420, 73, 49);
		btnJapan.addActionListener(gc);
		boardPanel.add(btnJapan);
		Country Japan = new Country(btnJapan);

		JButton btnAlaska = new JButton("Alaska");
		btnAlaska.setBounds(0, 51, 91, 106);
		btnAlaska.addActionListener(gc);
		boardPanel.add(btnAlaska);
		Country Alaska = new Country(btnAlaska);

		JButton btnNorthernTerritory = new JButton("North Territory");
		btnNorthernTerritory.setBounds(92, 51, 122, 97);
		btnNorthernTerritory.addActionListener(gc);
		boardPanel.add(btnNorthernTerritory);
		Country NorthernTerritory = new Country(btnNorthernTerritory);

		JButton btnOntario = new JButton("Ontario");
		btnOntario.setBounds(215, 51, 81, 148);
		btnOntario.addActionListener(gc);
		boardPanel.add(btnOntario);
		Country Ontario = new Country(btnOntario);

		JButton btnQuebec = new JButton("Quebec");
		btnQuebec.setBounds(300, 121, 97, 78);
		btnQuebec.addActionListener(gc);
		boardPanel.add(btnQuebec);
		Country Quebec = new Country(btnQuebec);

		JButton btnGreenland = new JButton("Greenland");
		btnGreenland.setBounds(398, 34, 162, 83);
		btnGreenland.addActionListener(gc);
		boardPanel.add(btnGreenland);
		Country Greenland = new Country(btnGreenland);

		JButton btnIceland = new JButton("Iceland");
		btnIceland.setBounds(550, 168, 81, 48);
		btnIceland.addActionListener(gc);
		boardPanel.add(btnIceland);
		Country Iceland = new Country(btnIceland);

		JButton btnAlberta = new JButton("Alberta");
		btnAlberta.setBounds(102, 148, 112, 51);
		btnAlberta.addActionListener(gc);
		boardPanel.add(btnAlberta);
		Country Alberta = new Country(btnAlberta);

		JButton btnWesternUnitedStates = new JButton("Western United States");
		btnWesternUnitedStates.setBounds(75, 201, 162, 178);
		btnWesternUnitedStates.addActionListener(gc);
		boardPanel.add(btnWesternUnitedStates);
		Country WesternUnitedStates = new Country(btnWesternUnitedStates);

		JButton btnEasternUnitedStates = new JButton("Eastern United States");
		btnEasternUnitedStates.setBounds(239, 201, 162, 178);
		btnEasternUnitedStates.addActionListener(gc);
		boardPanel.add(btnEasternUnitedStates);
		Country EasternUnitedStates = new Country(btnEasternUnitedStates);

		JButton btnFlorida = new JButton("Florida");
		btnFlorida.setBounds(356, 376, 73, 36);
		btnFlorida.addActionListener(gc);
		boardPanel.add(btnFlorida);
		Country Florida = new Country(btnFlorida);

		JButton btnMexico = new JButton("Mexico");
		btnMexico.setBounds(114, 379, 184, 93);
		btnMexico.addActionListener(gc);
		boardPanel.add(btnMexico);
		Country Mexico = new Country(btnMexico);

		JButton btnCentralAmerica = new JButton("Central America");
		btnCentralAmerica.setBounds(199, 471, 146, 83);
		btnCentralAmerica.addActionListener(gc);
		boardPanel.add(btnCentralAmerica);
		Country CentralAmerica = new Country(btnCentralAmerica);

		JButton btnVenezuela = new JButton("Venezuela");
		btnVenezuela.setBounds(239, 562, 130, 51);
		btnVenezuela.addActionListener(gc);
		boardPanel.add(btnVenezuela);
		Country Venezuela = new Country(btnVenezuela);

		JButton btnBrazil = new JButton("Brazil");
		btnBrazil.setBounds(300, 616, 162, 97);
		btnBrazil.addActionListener(gc);
		boardPanel.add(btnBrazil);
		Country Brazil = new Country(btnBrazil);

		JButton btnArgentina = new JButton("Argentina");
		btnArgentina.setBounds(248, 714, 149, 140);
		btnArgentina.addActionListener(gc);
		boardPanel.add(btnArgentina);
		Country Argentina = new Country(btnArgentina);

		countries.add(Kamchatka);
		countries.add(Yakutsk);
		countries.add(NorthAfrica);
		countries.add(Egypt);
		countries.add(Congo);
		countries.add(EastAfrica);
		countries.add(SouthAfrica);
		countries.add(WesternEurope);
		countries.add(SouthernEurope);
		countries.add(NorthernEurope);
		countries.add(GreatBritain);
		countries.add(Scandinavia);
		countries.add(Ukraine);
		countries.add(MiddleEast);
		countries.add(India);
		countries.add(Korea);
		countries.add(Indonesia);
		countries.add(NewGuinea);
		countries.add(WestAustralia);
		countries.add(EastAustralia);
		countries.add(LotR);
		countries.add(China);
		countries.add(Afghanistan);
		countries.add(Siberia);
		countries.add(Irkutsk);
		countries.add(Mongolia);
		countries.add(Japan);
		countries.add(Alaska);
		countries.add(NorthernTerritory);
		countries.add(Ontario);
		countries.add(Quebec);
		countries.add(Greenland);
		countries.add(Iceland);
		countries.add(Alberta);
		countries.add(WesternUnitedStates);
		countries.add(EasternUnitedStates);
		countries.add(Florida);
		countries.add(Mexico);
		countries.add(CentralAmerica);
		countries.add(Venezuela);
		countries.add(Brazil);
		countries.add(Argentina);
	}
}
