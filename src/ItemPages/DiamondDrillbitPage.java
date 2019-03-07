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

import Inventory.DiamondDrillbit;

public class DiamondDrillbitPage implements ActionListener{
	public JButton buyDrill;
	JButton buttonBack;
	JPanel drillWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildDrillPage(){
		drillWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Buying Drill; Swing Constants allow centered text------------------------------------
		JLabel ddName = new JLabel("Diamond Drillbit");
		JLabel ddDescrip = new JLabel("Diamond Production +25%");
		JLabel ddPrice = new JLabel("$20,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(ddName);
		text.add(ddDescrip);
		text.add(ddPrice);
		ddName.setFont(new Font("Verdana", Font.BOLD, 20));
		ddName.setAlignmentX(Component.CENTER_ALIGNMENT);
		ddDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		ddDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		ddPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		ddPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyDrill = new JButton ("BUY");
		
		buyDrill.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
		
		drillWindow.setLayout(new BorderLayout());
		drillWindow.add(buttonBack, BorderLayout.NORTH);
		drillWindow.add(textbuttons, BorderLayout.CENTER);
		drillWindow.add(buyDrill, BorderLayout.SOUTH);

		return drillWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buyDrill)
			{drillBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void drillBuy(){
		if (VMGame.resources.getMoney() >= 20000 && !VMGame.store.drillPurchased()){
			VMGame.resources.removeMoney(20000);
			VMGame.store.setDrillPurchased(true);
			JOptionPane.showMessageDialog(null, "You've refitted your drills with diamond tips" + "\n" + 
			"(This will slightly increase your diamond production)", "Drillbit Purchased!", JOptionPane.PLAIN_MESSAGE);
			buyDrill.setVisible(false);
			VMGame.disasters.dynaFire();
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to purchase this", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
		}
	
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.ddOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(drillWindow);
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
