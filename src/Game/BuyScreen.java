package Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BuyScreen implements ActionListener{
	
//------Buy Worker Buttons--------------------------------------------------------------------------
	JButton buttonDiamondMinerBuy;
	JButton buttonMarbleMinerBuy;
	JButton buttonGraniteMinerBuy;
	JButton buttonLimestoneMinerBuy;
	
	JButton buttonBack;
	
	JPanel workerBuyPanel;
	JPanel buyPanel;
	
	public JPanel BuildBuyScreen(){
		workerBuyPanel = new JPanel();
		buttonBack = new JButton ("BACK");
		
//------Buy Worker Buttons--------------------------------------------------------------------------
		buttonDiamondMinerBuy = new JButton("Hire Diamond Miner ($10,000)");
		buttonMarbleMinerBuy = new JButton("Hire Marble Miner ($5,000)");
		buttonGraniteMinerBuy = new JButton("Hire Granite Miner ($1,250)");
		buttonLimestoneMinerBuy = new JButton("Hire Limestone Miner ($250)");
		
//------Worker Buy Buttons---------------------------------------------------------------------------
		buyPanel = new JPanel();
		buyPanel.add(buttonDiamondMinerBuy);
		buyPanel.add(buttonMarbleMinerBuy);
		buyPanel.add(buttonGraniteMinerBuy);
		buyPanel.add(buttonLimestoneMinerBuy);
	
//------Action Listeners--------------------------------------------------------------------------
		buttonDiamondMinerBuy.addActionListener(this);
		buttonMarbleMinerBuy.addActionListener(this);
		buttonGraniteMinerBuy.addActionListener(this);
		buttonLimestoneMinerBuy.addActionListener(this);
		
		buttonBack.addActionListener(this);
		
		buyPanel.setLayout(new GridLayout(0,1));
		
		JPanel buyBuild = new JPanel();
		buyBuild.setLayout(new BorderLayout());
		buyBuild.add(VMGame.resources.BuildBuyImage(), BorderLayout.NORTH);
		buyBuild.add(buyPanel, BorderLayout.CENTER);
		
		workerBuyPanel.setLayout(new BorderLayout());
		workerBuyPanel.add(buyBuild, BorderLayout.CENTER);
		workerBuyPanel.add(buttonBack, BorderLayout.NORTH);
		
		return workerBuyPanel;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();	
//------Buy Workers Button Actions--------------------------------------------------------------------
		if(source == buttonDiamondMinerBuy)
			{buttonBuyDiamondMiner();}
		if(source == buttonMarbleMinerBuy)
			{buttonBuyMarbleMiner();}
		if(source == buttonGraniteMinerBuy)
			{buttonBuyGraniteMiner();}
		if(source == buttonLimestoneMinerBuy)
			{buttonBuyLimestoneMiner();}
		
//------Back Button Action-----------------------------------------------------------------------		
		if(source == buttonBack)
			{backButton();}
	}
	
//------Buy Workers Methods-------------------------------------------------------------------------
	public void buttonBuyDiamondMiner(){
		if (VMGame.resources.getMoney() >= 10000){
			VMGame.resources.removeMoney(10000);
			VMGame.resources.addDiamondWorkers();
		}
	}	
	public void buttonBuyMarbleMiner(){
		if (VMGame.resources.getMoney() >= 5000){
			VMGame.resources.removeMoney(5000);
			VMGame.resources.addMarbleWorkers();
		}
	}
	public void buttonBuyGraniteMiner(){
		if (VMGame.resources.getMoney() >= 1250){
			VMGame.resources.removeMoney(1250);
			VMGame.resources.addGraniteWorkers();
		}
	}	
	public void buttonBuyLimestoneMiner(){
		if (VMGame.resources.getMoney() >= 250){
			VMGame.resources.removeMoney(250);
			VMGame.resources.addLimestoneWorkers();
		}
	}
	public void backButton(){
		VMGame.buyOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(workerBuyPanel);
		VMGame.totalScreen.repaint();
		VMGame.mainWindow.setContentPane(VMGame.totalScreen);
		VMGame.mainWindow.setTitle("Vulcan Materials: Mining Operations");
		VMGame.mainWindow.revalidate();
	}
}
