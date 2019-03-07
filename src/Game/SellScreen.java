package Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SellScreen implements ActionListener{
	
//------Sell Resources Buttons-----------------------------------------------------------------------
	JButton buttonDiamondSell;
	JButton buttonMarbleSell;
	JButton buttonGraniteSell;
	JButton buttonLimestoneSell;
	JButton buttonRockdustSell;
	JButton buttonMixerRockdustSell;
		
//------Sell All Resources Buttons-------------------------------------------------------------------
	JButton buttonDiamondSellAll;
	JButton buttonMarbleSellAll;
	JButton buttonGraniteSellAll;
	JButton buttonLimestoneSellAll;
	JButton buttonRockdustSellAll;
	JButton buttonMixerRockdustSellAll;
	
	JButton buttonBack;
	
	JPanel resourceSellPanel;
	JPanel resourceSellAllPanel;
	JPanel sellPanel;
	
	public JPanel BuildSellScreen(){
		
		buttonBack = new JButton ("BACK");
	
//------Sell Resources Buttons----------------------------------------------------------------------
		buttonDiamondSell = new JButton("Sell 1 Ton Diamonds ($250)");
		buttonMarbleSell = new JButton("Sell 2 Tons Marble ($70)");
		buttonGraniteSell = new JButton("Sell 5 Tons Granite ($45)");
		buttonLimestoneSell = new JButton("Sell 20 Tons Limestone ($25)");
		buttonRockdustSell = new JButton("Sell 50 Tons Rock Dust ($15)");
		buttonMixerRockdustSell = new JButton("Sell 50 Tons Rock Dust($25)");
			
//------Sell All Resources Buttons-------------------------------------------------------------------
		buttonDiamondSellAll = new JButton("Sell all Diamonds ($250 Per)");
		buttonMarbleSellAll = new JButton("Sell all Marble ($35 Per)");
		buttonGraniteSellAll = new JButton("Sell all Granite ($9 Per)");
		buttonLimestoneSellAll = new JButton("Sell all Limestone ($1.25 Per)");
		buttonRockdustSellAll = new JButton("Sell all Rock Dust ($0.3 Per)");
		buttonMixerRockdustSellAll = new JButton("Sell all Rock Dust ($0.5 Per)");
	
//------Resources Sell Buttons----------------------------------------------------------------------
		resourceSellPanel = new JPanel();
		resourceSellPanel.add(buttonDiamondSell);
		resourceSellPanel.add(buttonMarbleSell);
		resourceSellPanel.add(buttonGraniteSell);
		resourceSellPanel.add(buttonLimestoneSell);
			if (VMGame.store.mixerPurchased()){
				resourceSellPanel.remove(buttonRockdustSell);
				resourceSellPanel.add(buttonMixerRockdustSell);
				}
			else
				{resourceSellPanel.add(buttonRockdustSell);}
			
//------Resources Sell All Buttons------------------------------------------------------------------
		resourceSellAllPanel = new JPanel();
		resourceSellAllPanel.add(buttonDiamondSellAll);
		resourceSellAllPanel.add(buttonMarbleSellAll);
		resourceSellAllPanel.add(buttonGraniteSellAll);
		resourceSellAllPanel.add(buttonLimestoneSellAll);
			if (VMGame.store.mixerPurchased())
				{resourceSellAllPanel.add(buttonMixerRockdustSellAll);}
			else
				{resourceSellAllPanel.add(buttonRockdustSellAll);}
			
//------Action Listeners-----------------------------------------------------------------------------
		buttonDiamondSell.addActionListener(this);
		buttonMarbleSell.addActionListener(this);
		buttonGraniteSell.addActionListener(this);
		buttonLimestoneSell.addActionListener(this);
		buttonRockdustSell.addActionListener(this);
		buttonMixerRockdustSell.addActionListener(this);
		
		buttonDiamondSellAll.addActionListener(this);
		buttonMarbleSellAll.addActionListener(this);
		buttonGraniteSellAll.addActionListener(this);
		buttonLimestoneSellAll.addActionListener(this);
		buttonRockdustSellAll.addActionListener(this);
		buttonMixerRockdustSellAll.addActionListener(this);
		
		buttonBack.addActionListener(this);
		
		resourceSellAllPanel.setLayout(new GridLayout(0,1));
		resourceSellPanel.setLayout(new GridLayout(0,1));
		
		JPanel sellBuild = new JPanel();
		sellBuild.setLayout(new BorderLayout());
		sellBuild.add(VMGame.resources.BuildSellImage(), BorderLayout.NORTH);
		if (VMGame.store.truckPurchased())
			{sellBuild.add(resourceSellAllPanel, BorderLayout.CENTER);}
		else
			{sellBuild.add(resourceSellPanel, BorderLayout.CENTER);}
		
		sellPanel = new JPanel();
		sellPanel.setLayout(new BorderLayout());
		sellPanel.add(sellBuild, BorderLayout.CENTER);
		sellPanel.add(buttonBack, BorderLayout.NORTH);
		
		return sellPanel;
	}
	
		public void actionPerformed(ActionEvent A){
			Object source = A.getSource();	
		
//------Sell Resources Button Actions----------------------------------------------------------------	
		if(source == buttonDiamondSell)
			{buttonSellDiamond();}
		if(source == buttonMarbleSell)
			{buttonSellMarble();}
		if(source == buttonGraniteSell)
			{buttonSellGranite();}
		if(source == buttonLimestoneSell)
			{buttonSellLimestone();}
		if(source == buttonRockdustSell)
			{buttonSellRockdust();}
		if(source == buttonMixerRockdustSell)
			{buttonMixerSellRockdust();}	
	
//------Sell All Resources Button Actions------------------------------------------------------------		
		if(source == buttonDiamondSellAll)
			{buttonSellAllDiamond();}
		if(source == buttonMarbleSellAll)
			{buttonSellAllMarble();}
		if(source == buttonGraniteSellAll)
			{buttonSellAllGranite();}
		if(source == buttonLimestoneSellAll)
			{buttonSellAllLimestone();}
		if(source == buttonRockdustSellAll)
			{buttonSellAllRockdust();}
		if(source == buttonMixerRockdustSellAll)
			{buttonMixerSellAllRockdust();}
		
//------Back Button Action-------------------------------------------------------------------------		
		if(source == buttonBack)
			{backButton();}
}
		
//------Sell Resources Methods-----------------------------------------------------------------------
	public void buttonSellDiamond(){
			if (VMGame.resources.getDiamond() >= 1){
				VMGame.resources.removeDiamonds(1);
				VMGame.resources.addMoney(250.0);
				VMGame.stats.diamondStatistics.addTotalEarned(250.0);
		}
	}	
	public void buttonSellMarble(){
		if (VMGame.resources.getMarble() >= 2){
			VMGame.resources.removeMarble(2);
			VMGame.resources.addMoney(70.0);
			VMGame.stats.marbleStatistics.addTotalEarned(70.0);
		}
	}	
	public void buttonSellGranite(){
		if (VMGame.resources.getGranite() >= 5){
			VMGame.resources.removeGranite(5);
			VMGame.resources.addMoney(45.0);
			VMGame.stats.graniteStatistics.addTotalEarned(45.0);
		}
	}	
	public void buttonSellLimestone(){
		if (VMGame.resources.getLimestone() >= 20){
			VMGame.resources.removeLimestone(20);
			VMGame.resources.addMoney(25.0);
			VMGame.stats.limestoneStatistics.addTotalEarned(25.0);
		}
	}
		
	public void buttonSellRockdust(){
		if (VMGame.resources.getRockdust() >= 50){
			VMGame.resources.removeRockdust(50);
			VMGame.resources.addMoney(15.0);
			VMGame.stats.rockdustStatistics.addTotalEarned(15.0);
		}
	}	
	public void buttonMixerSellRockdust(){
		if (VMGame.resources.getRockdust() >= 50){
			VMGame.resources.removeRockdust(50);
			VMGame.resources.addMoney(25.0);
			VMGame.stats.rockdustStatistics.addTotalEarned(25.0);
		}
	}
		
//------Sell All Resources Methods-------------------------------------------------------------------
	public void buttonSellAllDiamond(){
		if (VMGame.resources.getDiamond() > 0){
			int d = VMGame.resources.getDiamond();
			VMGame.resources.removeDiamonds(d);
			VMGame.resources.addMoney(d*250.0);
			VMGame.stats.diamondStatistics.addTotalEarned(d*250.0);
		}
	}	
	public void buttonSellAllMarble(){
		if (VMGame.resources.getMarble() > 0){
			int m = VMGame.resources.getMarble();
			VMGame.resources.removeMarble(m);
			VMGame.resources.addMoney(m*35.0);
			VMGame.stats.marbleStatistics.addTotalEarned(m*25.0);
		}
	}
	public void buttonSellAllGranite(){
		if (VMGame.resources.getGranite() > 0){
			int g = VMGame.resources.getGranite();
			VMGame.resources.removeGranite(g);
			VMGame.resources.addMoney(g*9.0);
			VMGame.stats.graniteStatistics.addTotalEarned(g*9.0);
		}
	}
	public void buttonSellAllLimestone(){
		if (VMGame.resources.getLimestone() > 0){
			int ls = VMGame.resources.getLimestone();
			VMGame.resources.removeLimestone(ls);
			VMGame.resources.addMoney(ls*1.25);
			VMGame.stats.limestoneStatistics.addTotalEarned(ls*1.25);
		}
	}	
	public void buttonSellAllRockdust(){
		if (VMGame.resources.getRockdust() > 0){
			int rd = VMGame.resources.getRockdust();
			VMGame.resources.removeRockdust(rd);
			VMGame.resources.addMoney(rd*0.3);
			VMGame.stats.rockdustStatistics.addTotalEarned(rd*0.3);
		}
	}
	public void buttonMixerSellAllRockdust(){
		if (VMGame.resources.getRockdust() > 0){
			int rd = VMGame.resources.getRockdust();
			VMGame.resources.removeRockdust(rd);
			VMGame.resources.addMoney(rd*0.5);
			VMGame.stats.rockdustStatistics.addTotalEarned(rd*0.5);
		}
	}
	
	public void backButton(){
		VMGame.sellOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(sellPanel);
		VMGame.totalScreen.repaint();
		VMGame.mainWindow.setContentPane(VMGame.totalScreen);
		VMGame.mainWindow.setTitle("Vulcan Materials: Mining Operations");
		VMGame.mainWindow.revalidate();
	}
			
}
