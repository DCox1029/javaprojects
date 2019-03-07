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
import Inventory.DumpTruck;

public class DumpTruckPage implements ActionListener{
	public JButton buyTruck;
	JButton buttonBack;
	JPanel truckWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildTruckPage(){
		truckWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
//------Button for buying Dump Trucks-------------------------------------------------------------------
		buyTruck = new JButton();
		JLabel tName = new JLabel("Dump Trucks");
		JLabel tDescrip = new JLabel("<html><center>Can sell all resources at once</center></html>");
		JLabel tPrice = new JLabel("$10,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(tName);
		text.add(tDescrip);
		text.add(tPrice);
		tName.setFont(new Font("Verdana", Font.BOLD, 20));
		tName.setAlignmentX(Component.CENTER_ALIGNMENT);
		tDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		tDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		tPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		tPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyTruck = new JButton ("BUY");
						
		buyTruck.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
						
		truckWindow.setLayout(new BorderLayout());
		truckWindow.add(buttonBack, BorderLayout.NORTH);
		truckWindow.add(textbuttons, BorderLayout.CENTER);
		truckWindow.add(buyTruck, BorderLayout.SOUTH);

		return truckWindow;
	}
		
		public void actionPerformed(ActionEvent A){
			Object source = A.getSource();
			
			if(source == buyTruck)
				{truckBuy();}
			if(source == buttonBack)
				{backButton();}
		}
		
	public void truckBuy(){
		if (VMGame.resources.getMoney() >= 10000 && !VMGame.store.truckPurchased()){
			VMGame.resources.removeMoney(10000);
			VMGame.store.setTruckPurchased(true);
			JOptionPane.showMessageDialog(null, "You've supplied your plants with super dump trucks" + "\n" +
			"(This will allow you to sell all of your resources with one click)", "Super Dump Trucks Purchased!", JOptionPane.PLAIN_MESSAGE);
			buyTruck.setVisible(false);
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to purchase this", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
	}
		
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.truckOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(truckWindow);
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
