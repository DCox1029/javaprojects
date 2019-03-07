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

public class SurveyorsPage implements ActionListener {
	public JButton buySurveyor;
	JButton buttonBack;
	JPanel surveyorWindow;
	JPanel text;
	JPanel textbuttons;
	
	JLabel moneyLabel;
	DecimalFormat moneyFormat;
	
	public JPanel BuildSurveyorsPage(){
		surveyorWindow = new JPanel();
		text = new JPanel();
		textbuttons = new JPanel();
		
		moneyLabel = new JLabel();
		
//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Hiring Interns-----------------------------------------------------------
		buySurveyor = new JButton();
		JLabel sName = new JLabel("<html><center>Mineral Surveyors</center></html>");
		JLabel sDescrip = new JLabel("<html><center>Increases chance of finding mineral veins</center></html>");
		JLabel sPrice = new JLabel("$30,000");
		text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
		text.add(sName);
		text.add(sDescrip);
		text.add(sPrice);
		sName.setFont(new Font("Verdana", Font.BOLD, 20));
		sName.setAlignmentX(Component.CENTER_ALIGNMENT);
		sDescrip.setFont(new Font("Verdana", Font.PLAIN, 13));
		sDescrip.setAlignmentX(Component.CENTER_ALIGNMENT);
		sPrice.setFont(new Font("Verdana", Font.BOLD, 22));
		sPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buySurveyor= new JButton ("BUY");
								
		buySurveyor.addActionListener(this);
		buttonBack.addActionListener(this);
		
		textbuttons.setLayout(new BorderLayout());
		textbuttons.add(text, BorderLayout.CENTER);
		textbuttons.add(moneyLabel, BorderLayout.SOUTH);
								
		surveyorWindow.setLayout(new BorderLayout());
		surveyorWindow.add(buttonBack, BorderLayout.NORTH);
		surveyorWindow.add(textbuttons, BorderLayout.CENTER);
		surveyorWindow.add(buySurveyor, BorderLayout.SOUTH);

		return surveyorWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buySurveyor)
			{surveyorBuy();}
		if(source == buttonBack)
			{backButton();}
	}
	
	public void surveyorBuy(){
		if (VMGame.resources.getMoney() >= 30000 && !VMGame.store.internsPurchased()){
			VMGame.resources.removeMoney(30000);
			VMGame.store.setSurveyorsPurchased(true);
			JOptionPane.showMessageDialog(null, "You've hired surveyors to scan for mineral veins" + "\n" +
			"(This will greatly increase the chance of finding diamond and gold veins)", "Surveyors Hired!", JOptionPane.PLAIN_MESSAGE);
			buySurveyor.setVisible(false);
			VMGame.treasures.surveyorsAdd();
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
		VMGame.mainWindow.remove(surveyorWindow);
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
