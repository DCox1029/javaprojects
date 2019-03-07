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
import Inventory.CementMixer;


public class CementMixerPage implements ActionListener {
	public JButton buyMixer;
	JButton buttonBack;
	JPanel mixerWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildMixerPage(){
		mixerWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for buying Cement Mixers-------------------------------------------------------------------
		buyMixer = new JButton();
		JLabel mName = new JLabel("Cement Mixers");
		JLabel mDescrip = new JLabel("Rock dust value +$0.2");
		JLabel mPrice = new JLabel("5,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(mName);
		text.add(mDescrip);
		text.add(mPrice);
		mName.setFont(new Font("Verdana", Font.BOLD, 20));
		mName.setAlignmentX(Component.CENTER_ALIGNMENT);
		mDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		mDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		mPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		mPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyMixer = new JButton ("BUY");
				
		buyMixer.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
				
		mixerWindow.setLayout(new BorderLayout());
		mixerWindow.add(buttonBack, BorderLayout.NORTH);
		mixerWindow.add(textbuttons, BorderLayout.CENTER);
		mixerWindow.add(buyMixer, BorderLayout.SOUTH);

		return mixerWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buyMixer)
			{mixerBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void mixerBuy(){
		if (VMGame.resources.getMoney() >= 10000 && !VMGame.store.mixerPurchased()){
			VMGame.resources.removeMoney(10000);
			VMGame.store.setMixerPurchased(true);
			JOptionPane.showMessageDialog(null, "You've supplied your plants with cement mixers" + "\n" +
			"(This will increase the price you can sell your rock dust)", "Cement Mixers Purchased!", JOptionPane.PLAIN_MESSAGE);
			buyMixer.setVisible(false);
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to purchase this", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.mixerOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(mixerWindow);
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
