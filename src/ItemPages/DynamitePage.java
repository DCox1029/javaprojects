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
import Inventory.Dynamite;

public class DynamitePage implements ActionListener {
	public JButton buyDynamite;
	JButton buttonBack;
	JPanel dynaWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildDynamitePage(){
		dynaWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Buying Dynamite; Swing Constants allow centered text------------------------------		
		buyDynamite = new JButton();
		JLabel dyName = new JLabel("<html><center>High Impact Dynamite</center></html>");
		JLabel dyDescrip = new JLabel("Rock Dust Production x2");
		JLabel dyWarning = new JLabel("<html><center>(Warning: Increases chance of forest fires by 8%)</center></html>");
		JLabel dyPrice = new JLabel("$2,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(dyName);
		text.add(dyDescrip);
		text.add(dyWarning);
		text.add(dyPrice);
		dyName.setFont(new Font("Verdana", Font.BOLD, 20));
		dyName.setAlignmentX(Component.CENTER_ALIGNMENT);
		dyDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		dyDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		dyWarning.setFont(new Font("Verdana", Font.BOLD, 8));
		dyWarning.setAlignmentX(Component.CENTER_ALIGNMENT);
		dyPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		dyPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyDynamite= new JButton ("BUY");
								
		buyDynamite.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
								
		dynaWindow.setLayout(new BorderLayout());
		dynaWindow.add(buttonBack, BorderLayout.NORTH);
		dynaWindow.add(textbuttons, BorderLayout.CENTER);
		dynaWindow.add(buyDynamite, BorderLayout.SOUTH);

		return dynaWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buyDynamite)
			{dynamiteBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void dynamiteBuy(){
		if (VMGame.resources.getMoney() >= 2000 && !VMGame.store.dynamitePurchased()){
			VMGame.resources.removeMoney(2000);
			VMGame.store.setDynamitePurchased(true);
			JOptionPane.showMessageDialog(null, "You've supplied your workers with more powerful dynamite" + "\n" +
			"(This will double your Rock Dust production)", "Dynamite Purchased!", JOptionPane.PLAIN_MESSAGE);
			buyDynamite.setVisible(false);
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to purchase this", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.dynamiteOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(dynaWindow);
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
