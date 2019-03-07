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

public class FireExtinguisherPage implements ActionListener {
	public JButton buyExtinguisher;
	JButton buttonBack;
	JPanel extinguisherWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildExtinguisherPage(){
		extinguisherWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Buying Fire Extinguisher---------------------------------------------------------
		buyExtinguisher = new JButton();
		JLabel feName = new JLabel("Fire Extinguishers");
		JLabel feDescrip = new JLabel("<html><center>Reduces chance of forest fires by 12%</html></center>");
		JLabel fePrice = new JLabel("$25,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(feName);
		text.add(feDescrip);
		text.add(fePrice);
		feName.setFont(new Font("Verdana", Font.BOLD, 18));
		feName.setAlignmentX(Component.CENTER_ALIGNMENT);
		feDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		feDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		fePrice.setFont(new Font("Verdana", Font.BOLD, 22));
		fePrice.setAlignmentX(Component.CENTER_ALIGNMENT);
				
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buyExtinguisher= new JButton ("BUY");
										
		buyExtinguisher.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
										
		extinguisherWindow.setLayout(new BorderLayout());
		extinguisherWindow.add(buttonBack, BorderLayout.NORTH);
		extinguisherWindow.add(textbuttons, BorderLayout.CENTER);
		extinguisherWindow.add(buyExtinguisher, BorderLayout.SOUTH);

		return extinguisherWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buyExtinguisher)
			{extinguisherBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void extinguisherBuy(){
		if (VMGame.resources.getMoney() >= 25000 && !VMGame.store.extinguisherPurchased()){
			VMGame.resources.removeMoney(25000);
			VMGame.store.setExtinguisherPurchased(true);
			JOptionPane.showMessageDialog(null, "You've updated your plants with state of the art fire extinguishers" + "\n" + 
			"(This will reduce the chance of forest fires by a moderate amount)", "Fire Extinguisher Purchased!", JOptionPane.PLAIN_MESSAGE);
			buyExtinguisher.setVisible(false);
			VMGame.disasters.extinguisherFire();
			VMGame.store.updateMoney();
			backButton();
		}
		else
			JOptionPane.showMessageDialog(null, "You do not have enough money to purchase this", "Not Enough Money!", JOptionPane.WARNING_MESSAGE);
	}
	public void backButton(){
		VMGame.storeOpen = true;
		VMGame.extinguisherOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(extinguisherWindow);
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
