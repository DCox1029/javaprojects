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

public class NetworkInternsPage implements ActionListener {
	public JButton buyIntern;
	JButton buttonBack;
	JPanel internWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildInternsPage(){
		internWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Hiring Interns-----------------------------------------------------------
		buyIntern = new JButton();
		JLabel niName = new JLabel("<html><center>Networking Interns</center></html>");
		JLabel niDescrip = new JLabel("<html><center>Reduces chance of WiFi outage by 26%</center></html>");
		JLabel niPrice = new JLabel("$18,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(niName);
		text.add(niDescrip);
		text.add(niPrice);
		niName.setFont(new Font("Verdana", Font.BOLD, 20));
		niName.setAlignmentX(Component.CENTER_ALIGNMENT);
		niDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		niDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		niPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		niPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyIntern= new JButton ("BUY");
								
		buyIntern.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
								
		internWindow.setLayout(new BorderLayout());
		internWindow.add(buttonBack, BorderLayout.NORTH);
		internWindow.add(textbuttons, BorderLayout.CENTER);
		internWindow.add(buyIntern, BorderLayout.SOUTH);

		return internWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buyIntern)
			{internBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void internBuy(){
		if (VMGame.resources.getMoney() >= 18000 && !VMGame.store.internsPurchased()){
			VMGame.resources.removeMoney(18000);
			VMGame.store.setInternsPurchased(true);
			JOptionPane.showMessageDialog(null, "You've hired interns to help monitor and support your networks" + "\n" +
			"(This will reduce the chance of the WiFi going down)", "Interns Hired!", JOptionPane.PLAIN_MESSAGE);
			buyIntern.setVisible(false);
			VMGame.disasters.internWifi();
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to hire these people", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.internOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(internWindow);
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
