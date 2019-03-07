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

public class AutomationPage implements ActionListener{
	public JButton buyAuto;
	JButton buttonBack;
	JPanel autoWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildAutoPage(){
		autoWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Buying Automation----------------------------------------------------------------
		buyAuto = new JButton();
		JLabel auName = new JLabel("Automation");
		JLabel auDescrip = new JLabel("All Production +50%");
		JLabel auWarning1 = new JLabel("<html><center>Warning: Increases chance of Internet outage by 30%</center></html>");
		JLabel auWarning2 = new JLabel("<html><center>Warning: Increases chance of WiFi outage by 30%</center></html>");
		JLabel auPrice = new JLabel("$100,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(auName);
		text.add(auDescrip);
		text.add(auWarning1);
		text.add(auWarning2);
		text.add(auPrice);
		auName.setFont(new Font("Verdana", Font.BOLD, 20));
		auName.setAlignmentX(Component.CENTER_ALIGNMENT);
		auDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		auDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		auWarning1.setFont(new Font("Verdana", Font.BOLD, 8));
		auWarning1.setAlignmentX(Component.CENTER_ALIGNMENT);
		auWarning2.setFont(new Font("Verdana", Font.BOLD, 8));
		auWarning2.setAlignmentX(Component.CENTER_ALIGNMENT);
		auPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		auPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyAuto = new JButton ("BUY");
						
		buyAuto.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
				
		autoWindow.setLayout(new BorderLayout());
		autoWindow.add(buttonBack, BorderLayout.NORTH);
		autoWindow.add(textbuttons, BorderLayout.CENTER);
		autoWindow.add(buyAuto, BorderLayout.SOUTH);

		return autoWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buyAuto)
			{automationBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void automationBuy(){
		if (VMGame.resources.getMoney() >= 100000 && !VMGame.store.automationPurchased()){
			VMGame.resources.removeMoney(100000);
			VMGame.store.setAutomationPurchased(true);
			JOptionPane.showMessageDialog(null, "You've installed automated machines in all your plants" + "\n" + 
			"(This will increase all production by a moderate amount)", "Automation Purchased!", JOptionPane.PLAIN_MESSAGE);
			buyAuto.setVisible(false);
			VMGame.disasters.autoInternet();
			VMGame.disasters.autoWifi();
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to purchase this", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.automationOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(autoWindow);
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

