package Game;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Statistics.DiamondStatistics;
import Statistics.DisasterStatistics;
import Statistics.GraniteStatistics;
import Statistics.LimestoneStatistics;
import Statistics.MarbleStatistics;
import Statistics.RockdustStatistics;
import Statistics.TreasureStatistics;


public class StatsScreen implements ActionListener {
	JPanel statsWindow;
	JPanel statsPanel;
	
	JButton buttonBack;
	
	DiamondStatistics diamondStatistics = new DiamondStatistics();
	MarbleStatistics marbleStatistics = new MarbleStatistics();
	GraniteStatistics graniteStatistics = new GraniteStatistics();
	LimestoneStatistics limestoneStatistics = new LimestoneStatistics();
	RockdustStatistics rockdustStatistics = new RockdustStatistics();
	DisasterStatistics disasterStatistics = new DisasterStatistics();
	TreasureStatistics treasureStatistics = new TreasureStatistics();

	public JPanel BuildGUI(){
		statsWindow = new JPanel();
		statsPanel = new JPanel();
		
		buttonBack = new JButton ("BACK");
		buttonBack.addActionListener(this);
		
		statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.PAGE_AXIS));
		
		statsWindow.setLayout(new BorderLayout());
		statsWindow.add(statsPanel, BorderLayout.CENTER);
		statsWindow.add(buttonBack, BorderLayout.NORTH);
		
		return statsWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buttonBack)
			{backButton();}
	}
	
//------Method for refreshing statistics---------------------------------------------------------------
	public void updateStatistics(){
		if (statsWindow!=null){
			if (VMGame.disasterOpen){
				statsWindow.revalidate();
				VMGame.mainWindow.remove(statsWindow);
				statsWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				statsPanel.add(disasterStatistics.BuildGUI());
				statsWindow.revalidate();}
			if (VMGame.treasureOpen){
				statsWindow.revalidate();
				VMGame.mainWindow.remove(statsWindow);
				statsWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				statsPanel.add(treasureStatistics.BuildGUI());
				statsWindow.revalidate();}
			if (VMGame.diamondOpen){
				statsWindow.revalidate();
				VMGame.mainWindow.remove(statsWindow);
				statsWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				statsPanel.add(diamondStatistics.BuildGUI());
				statsWindow.revalidate();}
			if (VMGame.marbleOpen){
				statsWindow.revalidate();
				VMGame.mainWindow.remove(statsWindow);
				statsWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				statsPanel.add(marbleStatistics.BuildGUI());
				statsWindow.revalidate();}
			if (VMGame.graniteOpen){
				statsWindow.revalidate();
				VMGame.mainWindow.remove(statsWindow);
				statsWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				statsPanel.add(graniteStatistics.BuildGUI());
				statsWindow.revalidate();}
			if (VMGame.limestoneOpen){
				statsWindow.revalidate();
				VMGame.mainWindow.remove(statsWindow);
				statsWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				statsPanel.add(limestoneStatistics.BuildGUI());
				statsWindow.revalidate();}
			if (VMGame.rockdustOpen){
				statsWindow.revalidate();
				VMGame.mainWindow.remove(statsWindow);
				statsWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				statsPanel.add(rockdustStatistics.BuildGUI());
				statsWindow.revalidate();}
		}
	}

//------Set the rate of resources generated per turn-----------------------------------------------------
	public void setDiamondRate(int diamondWorkers)
		{diamondStatistics.setRate(diamondWorkers);}
	public void setMarbleRate(int marbleWorkers)
		{marbleStatistics.setRate(marbleWorkers);}
	public void setGraniteRate(int graniteWorkers)
		{graniteStatistics.setRate(graniteWorkers);}
	public void setLimestoneRate(int limestoneWorkers)
		{limestoneStatistics.setRate(limestoneWorkers);}
	public void setRockdustRate(int rockdustWorkers)
		{rockdustStatistics.setRate(rockdustWorkers);}
	
//------Add the number of workers to the statistics--------------------------------------------------
	public void addDiamondWorkers(int diamondWorkers)
		{diamondStatistics.setWorkers(diamondWorkers);}
	public void addMarbleWorkers(int marbleWorkers)
		{marbleStatistics.setWorkers(marbleWorkers);}
	public void addGraniteWorkers(int graniteWorkers)
		{graniteStatistics.setWorkers(graniteWorkers);}
	public void addLimestoneWorkers(int limestoneWorkers)
		{limestoneStatistics.setWorkers(limestoneWorkers);}
	public void addRockdustWorkers(int rockdustWorkers)
		{rockdustStatistics.setWorkers(rockdustWorkers);}
	
//------Calculate the total number of resources produced for the entire game so far-----------------
	public void addDiamondsTotalProduced(int diamondsProduced)
		{diamondStatistics.addTotalProduced(diamondsProduced);}
	public void addMarbleTotalProduced(int marbleProduced)
		{marbleStatistics.addTotalProduced(marbleProduced);}
	public void addGraniteTotalProduced(int graniteProduced)
		{graniteStatistics.addTotalProduced(graniteProduced);}
	public void addLimestoneTotalProduced(int limestoneProduced)
		{limestoneStatistics.addTotalProduced(limestoneProduced);}
	public void addRockdustTotalProduced(int rockdustProduced)
		{rockdustStatistics.addTotalProduced(rockdustProduced);}
	
//------Calculate the total number of resources produced by automation item-------------------------
	public void addDiamondsAutoIncreased(int autoDiamond)
		{diamondStatistics.addAutoIncreased(autoDiamond);}
	public void addMarbleAutoIncreased(int autoMarble)
		{marbleStatistics.addAutoIncreased(autoMarble);}
	public void addGraniteAutoIncreased(int autoGranite)
		{graniteStatistics.addAutoIncreased(autoGranite);}
	public void addLimestoneAutoIncreased(int autoLimestone)
		{limestoneStatistics.addAutoIncreased(autoLimestone);}
	public void addRockdustAutoIncreased(int autoRockdust)
		{rockdustStatistics.addAutoIncreased(autoRockdust);}
	
//------Calculate the total number of resources produced by various other items---------------------
	public void addRockdustDynamiteIncreased(int dynaRockdust)
		{rockdustStatistics.addDynamiteIncreased(dynaRockdust);}
	public void addDiamondDrillIncreased (int drillDiamonds)
		{diamondStatistics.addDrillIncreased(drillDiamonds);}
	
//------Calculate the total number of resources produced by all items------------------------------------
	public void addDiamondItemsIncreased(int diamondItems)
		{diamondStatistics.addItemsIncreased(diamondItems);}
	public void addMarbleItemsIncreased(int marbleItems)
		{marbleStatistics.addItemsIncreased(marbleItems);}
	public void addGraniteItemsIncreased(int graniteItems)
		{graniteStatistics.addItemsIncreased(graniteItems);}
	public void addLimestoneItemsIncreased(int limestoneItems)
		{limestoneStatistics.addItemsIncreased(limestoneItems);}
	public void addRockdustItemsIncreased(int rockdustItems)
		{rockdustStatistics.addItemsIncreased(rockdustItems);}
		
	public void backButton(){
		VMGame.disasterOpen = false;
		VMGame.treasureOpen = false;
		VMGame.diamondOpen = false;
		VMGame.marbleOpen = false;
		VMGame.graniteOpen = false;
		VMGame.limestoneOpen = false;
		VMGame.rockdustOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(statsWindow);
		VMGame.totalScreen.repaint();
		VMGame.mainWindow.setContentPane(VMGame.totalScreen);
		VMGame.mainWindow.setTitle("Vulcan Materials: Mining Operations");
		VMGame.mainWindow.revalidate();
	}
}
