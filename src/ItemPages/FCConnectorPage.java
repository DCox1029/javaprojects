package ItemPages;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Game.VMGame;
import Inventory.FCConnector;

public class FCConnectorPage implements ActionListener {
	public JButton buyConnector;
	JButton buttonBack;
	JPanel connectorWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildConnectorPage(){
		connectorWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Buying FC Connectors---------------------------------------------------------
		buyConnector = new JButton();
		JLabel fcName = new JLabel("FC Connectors");
		JLabel fcDescrip = new JLabel("<html><center>Reduces chance of internet outage by 22%</center></html>");
		JLabel fcPrice = new JLabel("$15,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(fcName);
		text.add(fcDescrip);
		text.add(fcPrice);
		fcName.setFont(new Font("Verdana", Font.BOLD, 20));
		fcName.setAlignmentX(Component.CENTER_ALIGNMENT);
		fcDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		fcDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		fcPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		fcPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyConnector= new JButton ("BUY");
								
		buyConnector.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
								
		connectorWindow.setLayout(new BorderLayout());
		connectorWindow.add(buttonBack, BorderLayout.NORTH);
		connectorWindow.add(textbuttons, BorderLayout.CENTER);
		connectorWindow.add(buyConnector, BorderLayout.SOUTH);

		return connectorWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buyConnector)
			{connectorBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void connectorBuy(){
		if (VMGame.resources.getMoney() >= 15000 && !VMGame.store.connectorPurchased()){
			VMGame.resources.removeMoney(15000);
			VMGame.store.setConnectorPurchased(true);
			JOptionPane.showMessageDialog(null, "You've supplied your plants with fiber optic FC connectors" + "\n" +
			"(This will reduce the chance of the internet going out)", "FC Connectors Purchased!", JOptionPane.PLAIN_MESSAGE);
			buyConnector.setVisible(false);
			VMGame.disasters.connectorInternet();
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to purchase this", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.connectorOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(connectorWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(VMGame.store.BuildGUI());
		VMGame.mainWindow.setTitle("Vulcan Store");
		VMGame.mainWindow.revalidate();
		
		if (VMGame.store.dynamitePurchased())
			{VMGame.store.buyDynamite.setVisible(false);}
		if (VMGame.store.drillPurchased())
			{VMGame.store.buyDrill.setVisible(false);}
		if (VMGame.store.automationPurchased())
			{VMGame.store.buyAutomation.setVisible(false);}
		if (VMGame.store.extinguisherPurchased())
			{VMGame.store.buyExtinguisher.setVisible(false);}
		if (VMGame.store.connectorPurchased())
			{VMGame.store.buyConnector.setVisible(false);}
		if (VMGame.store.mixerPurchased())
			{VMGame.store.buyMixer.setVisible(false);}
		if (VMGame.store.truckPurchased())
			{VMGame.store.buyTruck.setVisible(false);}
		if (VMGame.store.internsPurchased())
			{VMGame.store.buyIntern.setVisible(false);}
		if (VMGame.store.surveyorsPurchased())
			{VMGame.store.buySurveyor.setVisible(false);}
	}
}
