package Game;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class VMGame implements ActionListener {
	
	public static JFrame mainWindow;
	
	public static JPanel sellbuyPanel;
	public static JPanel startstopPanel;
	public static JPanel totalScreen;
	public static JPanel resourceSellPanel;
	JPanel turnPanel;
	
	public static ResourceScreen resources = new ResourceScreen();
	public static StoreScreen store = new StoreScreen();
	public static StatsScreen stats = new StatsScreen();
	public static Disasters disasters = new Disasters();
	public static Treasures treasures = new Treasures();
	public static IntroductionScreen intro = new IntroductionScreen();
	public static SellScreen sell = new SellScreen();
	public static BuyScreen buy = new BuyScreen();
	
	private PlayScreen playScreen;
	private InventoryScreen inventory;
	
	JMenuBar menuButton;
	JMenuItem mNew; 
	JMenuItem mInventory;
	JMenuItem mStore;
	JMenuItem mDiamondStats;
	JMenuItem mMarbleStats;
	JMenuItem mGraniteStats;
	JMenuItem mLimestoneStats;
	JMenuItem mRockdustStats;
	JMenuItem mDisasterStats;
	JMenuItem mTreasureStats;
	
	JLabel turns;
	String numDays = "Days: " + days + "  ";
	
	public static JMenu fileMenu;
	public static JMenu storeMenu;
	public static JMenu statsMenu;

	public static int days = 1;
	int numWinMessage = 0;
	
//------These booleans are necessary for refreshing screens------------------------------------------
	public static boolean disasterOpen = false;
	public static boolean treasureOpen = false;
	public static boolean diamondOpen = false;
	public static boolean marbleOpen = false;
	public static boolean graniteOpen = false;
	public static boolean limestoneOpen = false;
	public static boolean rockdustOpen = false;
	public static boolean inventoryOpen = false;
	public static boolean storeOpen = false;
	
//------These booleans help with the next/back buttons of the introduction----------------------
	public static boolean introMainOpen = true;
	public static boolean introHowToPlayOpen = false;
	public static boolean introStoreOpen = false;
	public static boolean introStatisticsOpen = false;
	public static boolean introChancesOpen = false;
	public static boolean introGoalOpen = false;
	
//------These booleans help switch between items on the store page------------------------------
	public static boolean drillOpen = false;
	public static boolean mixerOpen = false;
	public static boolean ddOpen = false;
	public static boolean truckOpen = false;
	public static boolean dynamiteOpen = false;
	public static boolean connectorOpen = false;
	public static boolean extinguisherOpen = false;
	public static boolean automationOpen = false;
	public static boolean internOpen = false;
	public static boolean surveyorOpen = false;
	
//------These booleans help with the Buy/Sell Screens----------------------------------------------
	public static boolean sellOpen = false;
	public static boolean buyOpen = false;
	
//------Initialize the number of disaster days-----------------------------------------------------------------
	private static int floodDays = 0;
	private static int internetDays = 0;
	private static int wifiDays = 0;
	private static int fireDays = 0;
	
//------Booleans for whether treasures were found------------------------------------------------
	private static boolean fossilTreasure;
	private static boolean diamondTreasure;
	private static boolean goldTreasure;
	
//------Initialize all of the variables used for calculating resources---------------------------------	
	int randomDiamonds = 0;
	int randomMarble = 0;
	int randomGranite = 0;
	int randomLimestone = 0;
	int randomRockdust = 0;
	
	int autoRandomDiamonds = 0;
	int autoRandomMarble = 0;
	int autoRandomGranite = 0;
	int autoRandomLimestone = 0;
	int autoRandomRockdust = 0;
	
	int itemsRandomDiamonds = 0;
	int itemsRandomMarble = 0;
	int itemsRandomGranite = 0;
	int itemsRandomLimestone = 0;
	int itemsRandomRockdust = 0;
	
	int dynamiteRandomRockdust = 0;
	
	int drillRandomDiamonds = 0;
	
	int totalDiamondsProduced = 0;
	int totalMarbleProduced = 0;
	int totalGraniteProduced = 0;
	int totalLimestoneProduced = 0;
	int totalRockdustProduced = 0;
	
	int diamondsDamaged = 0;
	int marbleDamaged = 0;
	int graniteDamaged = 0;
	int limestoneDamaged = 0;
	int rockdustDamaged = 0;
	int totalDamaged = diamondsDamaged + marbleDamaged + graniteDamaged + limestoneDamaged + rockdustDamaged;
	
	int diamondsFound = 0;
	int fossilMoneyFound = 0;
	int diamondMoneyFound = 0;
	
//------Next/Back Buttons for navigating introduction-------------------------------------------------
	JButton next;
	JButton back;
	JPanel buttons;
	
//------Buy/Sell Buttons for exchanging resources-----------------------------------------------
	JButton buttonBuy;
	JButton buttonSell;
	
//------Timer Buttons-------------------------------------------------------------------------------
	ButtonGroup startstop;
	JRadioButton buttonStart;
	JRadioButton buttonStop;
	Timer timer;
	
//------Turn Button------------------------------------------------------------------------------------------
	JButton buttonTurn;
	
	public static void main(String args[]){
		new VMGame();
	}

//------Game Starts on its own Thread----------------------------------------------------------------
	public VMGame(){
	     SwingUtilities.invokeLater(new Runnable() {

	            public void run() {
	              	resources.addMoney(1000000.0);
	              	BuildIntroductionGUI();
	            	//BuildGameGUI();
	            }
	     });
	}
	public void BuildIntroductionGUI(){
		mainWindow = new JFrame();
		mainWindow.setLocationByPlatform(true);
		mainWindow.setSize(215, 270);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setResizable(true);
		mainWindow.setTitle("Introduction");
		mainWindow.setJMenuBar(menuButton);
		
		buttons = new JPanel();
		next = new JButton("NEXT");
		back = new JButton("BACK");
		buttons.add(back);
		buttons.add(next);
		back.setVisible(false);
		
		next.addActionListener(this);
		back.addActionListener(this);
		
		buttonBuy = new JButton("HIRE");
		buttonSell = new JButton("SELL");
		
		mainWindow.setLayout(new BorderLayout());
		mainWindow.add(intro.BuildMainGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setVisible(true);
	}
	
	public JPanel BuildGameGUI(){
		fileMenu = new JMenu("File");
		storeMenu = new JMenu("Store");
		statsMenu = new JMenu("Stats");
		mNew = new JMenuItem("New");
		mInventory = new JMenuItem("Inventory");
		mStore = new JMenuItem("Store");
		mDiamondStats = new JMenuItem("Diamond Statistics");
		mMarbleStats = new JMenuItem("Marble Statistics");
		mGraniteStats = new JMenuItem("Granite Statistics");
		mLimestoneStats = new JMenuItem("Limestone Statistics");
		mRockdustStats = new JMenuItem("Rockdust Statistics");
		mDisasterStats = new JMenuItem("Disaster Statistics");
		mTreasureStats = new JMenuItem("Treasure Statistics");
		turns = new JLabel(numDays);
		
		fileMenu.add(mNew);
		storeMenu.add(mStore);
		storeMenu.add(mInventory);
		statsMenu.add(mDiamondStats);
		statsMenu.add(mMarbleStats);
		statsMenu.add(mGraniteStats);
		statsMenu.add(mLimestoneStats);
		statsMenu.add(mRockdustStats);
		statsMenu.addSeparator();
		statsMenu.add(mTreasureStats);
		statsMenu.add(mDisasterStats);
		menuButton = new JMenuBar();
		menuButton.add(fileMenu);
		menuButton.add(storeMenu);
		menuButton.add(statsMenu);
		menuButton.add(Box.createHorizontalGlue());
		menuButton.add(turns);
		
		mainWindow.setTitle("Vulcan Materials: Mining Operations");
		mainWindow.setJMenuBar(menuButton);
		
		inventory = new InventoryScreen();
		totalScreen = new JPanel();
		
//------Start & Stop Buttons------------------------------------------------------------------------
		/*startstopPanel = new JPanel();
		buttonStart = new JRadioButton("Start");
		buttonStop = new JRadioButton("Stop");
		startstop = new ButtonGroup();
		startstop.add(buttonStart);
		startstop.add(buttonStop);
		startstopPanel.add(buttonStart);
		startstopPanel.add(buttonStop);*/
		
//------Turn Button------------------------------------------------------------------------------
		turnPanel = new JPanel();
		buttonTurn = new JButton("END TURN");
		turnPanel.add(buttonTurn);
		
		
//------Put the Panels Together----------------------------------------------------------------------
		sellbuyPanel = new JPanel();
		sellbuyPanel.add(buttonBuy);
		sellbuyPanel.add(buttonSell);
		
		totalScreen.setLayout(new BorderLayout());
		totalScreen.add(resources.BuildImage(), BorderLayout.NORTH);
		totalScreen.add(sellbuyPanel, BorderLayout.CENTER);
		//totalScreen.add(startstopPanel, BorderLayout.SOUTH);
		totalScreen.add(turnPanel, BorderLayout.SOUTH);
		
//------Action Listeners--------------------------------------------------------------------------		
		mNew.addActionListener(this);
		mInventory.addActionListener(this);
		mStore.addActionListener(this);
		
		mDiamondStats.addActionListener(this);
		mMarbleStats.addActionListener(this);
		mGraniteStats.addActionListener(this);
		mLimestoneStats.addActionListener(this);
		mRockdustStats.addActionListener(this);
		mDisasterStats.addActionListener(this);
		mTreasureStats.addActionListener(this);
		
		//buttonStart.addActionListener(this);
		//buttonStop.addActionListener(this);
		
		buttonTurn.addActionListener(this);
		
		buttonBuy.addActionListener(this);
		buttonSell.addActionListener(this);

		mainWindow.add(totalScreen);
		mainWindow.setVisible(true);
		return totalScreen;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();	
		
//------Introduction Next/Back Buttons---------------------------------------------------------
		if((source == next) && (introMainOpen == true))
			{mainNextAction();}
		
		if((source == next) && (introHowToPlayOpen))
			{howtoplayNextAction();}
		if((source == back) && (introHowToPlayOpen))
			{howtoplayBackAction();}
		
		if((source == next) && (introStoreOpen))
			{storeNextAction();}
		if((source == back) && (introStoreOpen))
			{storeBackAction();}
		
		if((source == next) && (introStatisticsOpen))
			{statsNextAction();}
		if((source == back) && (introStatisticsOpen))
			{statsBackAction();}
		
		if((source == next) && (introChancesOpen))
			{chancesNextAction();}
		if((source == back) && (introChancesOpen))
			{chancesBackAction();}
		
		if((source == next) && (introGoalOpen))
			{goalNextAction();}
		if((source == back) && (introGoalOpen))
			{goalBackAction();}
			
//------Menu Buttons---------------------------------------------------------------------------------
		if(source == mNew)
			{mNewAction();}
			
		if(source == mInventory)
			{mInventoryAction();}
		
		if(source == mStore)
			{mStoreAction();}
		
		if(source == mDiamondStats)
			{mDiamondStatsAction();}
		if(source == mMarbleStats)
			{mMarbleStatsAction();}
		if(source == mGraniteStats)
			{mGraniteStatsAction();}
		if(source == mLimestoneStats)
			{mLimestoneStatsAction();}
		if(source == mRockdustStats)
			{mRockdustStatsAction();}
		if(source == mDisasterStats)
			{mDisasterStatsAction();}
		if(source == mTreasureStats)
			{mTreasureStatsAction();}
		
		//if(source == buttonStart)
		//	{buttonStartAction();}
		//if(source == buttonStop)
		//	{buttonStopAction();}
		
		if(source == buttonBuy)
			{buttonBuyAction();}
		if(source == buttonSell)
			{buttonSellAction();}
		
		if(source == buttonTurn)
			{buttonTurnAction();}
}
	
//------Methods for setting whether treasures were found------------------------------------
	public static void setFossilBoolean(boolean fossilBoolean)
		{fossilTreasure = fossilBoolean;}
	public static void setDiamondBoolean(boolean diamondBoolean)
		{diamondTreasure = diamondBoolean;}
	public static void setGoldBoolean(boolean goldBoolean)
		{goldTreasure = goldBoolean;}
	
//------Methods for setting the disaster periods------------------------------------------------------
	public static void setFireDays(int fiDays)
		{fireDays = fiDays;}
	public static void setFloodDays(int flDays)
		{floodDays = flDays;}
	public static void setInternetDays(int iDays)
		{internetDays = iDays;}
	public static void setWifiDays(int wDays)
		{wifiDays = wDays;}
	
//------Method for getting whether or not any days are currently active--------------------
	public static int ifDays()
		{return (fireDays + floodDays + internetDays + wifiDays);}
	
//------Methods for inflicting disaster damage to resources--------------------------------------------
	public void setFireDamage(double fiDamage){
		diamondsDamaged = (int)(totalDiamondsProduced*disasters.getFireDamage());
		marbleDamaged = (int)(totalMarbleProduced*disasters.getFireDamage());
		graniteDamaged = (int)(totalGraniteProduced*disasters.getFireDamage());
		limestoneDamaged = (int)(totalLimestoneProduced*disasters.getFireDamage());
		rockdustDamaged = (int)(totalRockdustProduced*disasters.getFireDamage());
		
		stats.disasterStatistics.addDiamondsLost((int)diamondsDamaged);
		stats.disasterStatistics.addMarbleLost((int)marbleDamaged);
		stats.disasterStatistics.addGraniteLost((int)graniteDamaged);
		stats.disasterStatistics.addLimestoneLost((int)limestoneDamaged);
		stats.disasterStatistics.addLimestoneLost((int)rockdustDamaged);
		}
	
	public void setFloodDamage(double flDamage){
		diamondsDamaged = (int)(totalDiamondsProduced*disasters.getFloodDamage());
		marbleDamaged = (int)(totalMarbleProduced*disasters.getFloodDamage());
		graniteDamaged = (int)(totalGraniteProduced*disasters.getFloodDamage());
		limestoneDamaged = (int)(totalLimestoneProduced*disasters.getFloodDamage());
		rockdustDamaged = (int)(totalRockdustProduced*disasters.getFloodDamage());
		
		stats.disasterStatistics.addDiamondsLost((int)diamondsDamaged);
		stats.disasterStatistics.addMarbleLost((int)marbleDamaged);
		stats.disasterStatistics.addGraniteLost((int)graniteDamaged);
		stats.disasterStatistics.addLimestoneLost((int)limestoneDamaged);
		stats.disasterStatistics.addLimestoneLost((int)rockdustDamaged);
		}
	
	public void setInternetDamage(double iDamage){
		if (disasters.internetDiamondBoolean()){
			diamondsDamaged = (int)(totalDiamondsProduced*disasters.getInternetDamage());
			stats.disasterStatistics.addDiamondsLost((int)diamondsDamaged);
			}
		if (disasters.internetMarbleBoolean()){
			marbleDamaged = (int)(totalMarbleProduced*disasters.getInternetDamage());
			stats.disasterStatistics.addMarbleLost((int)marbleDamaged);
			}
		if (disasters.internetGraniteBoolean()){
			graniteDamaged = (int)(totalGraniteProduced*disasters.getInternetDamage());
			stats.disasterStatistics.addGraniteLost((int)graniteDamaged);
			}
		if (disasters.internetLimestoneBoolean()){
			limestoneDamaged = (int)(totalLimestoneProduced*disasters.getInternetDamage());
			stats.disasterStatistics.addLimestoneLost((int)limestoneDamaged);
		}
	}
	
	public void setWifiDamage(double wDamage){
		if (disasters.wifiDiamondBoolean()){
			diamondsDamaged = (int)(totalDiamondsProduced*disasters.getWifiDamage());
			stats.disasterStatistics.addDiamondsLost((int)diamondsDamaged);
		}
		if (disasters.wifiMarbleBoolean()){
			marbleDamaged = (int)(totalMarbleProduced*disasters.getWifiDamage());
			stats.disasterStatistics.addMarbleLost((int)marbleDamaged);
		}
		if (disasters.wifiGraniteBoolean()){
			graniteDamaged = (int)(totalGraniteProduced*disasters.getWifiDamage());
			stats.disasterStatistics.addGraniteLost((int)graniteDamaged);
		}
		if (disasters.wifiLimestoneBoolean()){
			limestoneDamaged = (int)(totalLimestoneProduced*disasters.getWifiDamage());
			stats.disasterStatistics.addLimestoneLost((int)limestoneDamaged);
		}
	}
	
//------Generates resources over time according to number of respective workers---------------------------
	//public void buttonStartAction(){
	public void buttonTurnAction(){
		//timer = new Timer();

		//timer.schedule( new TimerTask() {
		 //   public void run() {
		    	
//------Reset the resources each turn----------------------------------------------------------------
		    	randomDiamonds = 0;
		    	randomMarble = 0;
		    	randomGranite = 0;
		    	randomLimestone = 0;
		    	randomRockdust = 0;
		    	
		    	autoRandomDiamonds = 0;
		    	autoRandomMarble = 0;
		    	autoRandomGranite = 0;
		    	autoRandomLimestone = 0;
		    	autoRandomRockdust = 0;
		    	
		    	itemsRandomDiamonds = 0;
		    	itemsRandomMarble = 0;
		    	itemsRandomGranite = 0;
		    	itemsRandomLimestone = 0;
		    	itemsRandomRockdust = 0;
		    	
		    	dynamiteRandomRockdust = 0;
		    	
		    	drillRandomDiamonds = 0;
		    	
		    	totalDiamondsProduced = 0;
		    	totalMarbleProduced = 0;
		    	totalGraniteProduced = 0;
		    	totalLimestoneProduced = 0;
		    	totalRockdustProduced = 0;
		    	
		    	diamondsDamaged = 0;
		    	marbleDamaged = 0;
		    	graniteDamaged = 0;
		    	limestoneDamaged = 0;
		    	rockdustDamaged = 0;
		    	totalDamaged = diamondsDamaged + marbleDamaged + graniteDamaged + limestoneDamaged + rockdustDamaged;
		    
// Game is beaten once one million dollars is reached. Set a number of win messages so it doesn't
// repeat every turn.
		    	if (resources.getMoney() >= 1000000 && numWinMessage < 1){
		    		numWinMessage++;
		    		JOptionPane.showMessageDialog(null, "Congratulations! You reached one million dollars in " 
		    		+ days + " days!" + "\n" + "You've officially beaten the game. Press New to start a new game, " +
		    		"or continue to see if you can earn a billion dollars! ", 
		    		"You won!", JOptionPane.INFORMATION_MESSAGE);}
				
//------Check each turn for disasters------------------------------------------------------------------
				//disasters.disasterListener();
		    	
//------Check each turn for treasures------------------------------------------------------------------
		    	treasures.treasureListener();
		    	
		    	if (fossilTreasure){
		    		resources.addMoney(treasures.getFossilAmount());
		    		stats.treasureStatistics.addFossilMoneyEarned(treasures.getFossilAmount());
		    	}
		    	if (diamondTreasure){
		    		resources.addDiamonds(treasures.getDiamondAmount());
		    		stats.treasureStatistics.addDiamondsGained(treasures.getDiamondAmount());
		    		}
		    	if (goldTreasure){
		    		resources.addMoney(treasures.getGoldAmount());
		    		stats.treasureStatistics.addGoldMoneyEarned(treasures.getGoldAmount());
		    	}
		    	

// Use loops to ensure that you don't frequently produce 0 resources when quarry counts get high-------------------------
				for (int i=0; i<resources.getDiamondWorkers(); i++){
					Random randomDiamondGenerator = new Random();
					randomDiamonds = randomDiamonds + randomDiamondGenerator.nextInt(2);}
				
				for (int i=0; i<resources.getMarbleWorkers(); i++){
					Random randomMarbleGenerator = new Random();
					randomMarble = randomMarble + randomMarbleGenerator.nextInt(4);}
				
				for (int i=0; i<resources.getGraniteWorkers(); i++){
					Random randomGraniteGenerator = new Random();
					randomGranite = randomGranite + randomGraniteGenerator.nextInt(8);}
				
				for (int i=0; i<resources.getLimestoneWorkers(); i++){
					Random randomLimestoneGenerator = new Random();
					randomLimestone = randomLimestone + randomLimestoneGenerator.nextInt(12);}
				
				for (int i=0; i<resources.getTotalWorkers(); i++){
					Random randomRockdustGenerator = new Random();
					randomRockdust = randomRockdust + randomRockdustGenerator.nextInt(28);}
				
//------Incorporate Store Purchases-------------------------------------------------------------------
				if (store.drillPurchased())
					drillRandomDiamonds = (int)(randomDiamonds*0.25);
				
				if (store.automationPurchased()){
					autoRandomDiamonds = (int)(randomDiamonds*0.5);
					autoRandomMarble = (int)(randomMarble*0.5);
					autoRandomGranite = (int)(randomGranite*0.5);
					autoRandomLimestone = (int)(randomLimestone*0.5);
					autoRandomRockdust = (int)(randomRockdust*0.5);
				}
				
				if (store.dynamitePurchased())
					dynamiteRandomRockdust = randomRockdust;
				
//------Calculate all of the resources produced when including the amounts increased by items---------
				itemsRandomDiamonds = autoRandomDiamonds + drillRandomDiamonds;
				itemsRandomMarble = autoRandomMarble;
				itemsRandomGranite = autoRandomGranite;
				itemsRandomLimestone = autoRandomLimestone;
				itemsRandomRockdust = autoRandomRockdust + dynamiteRandomRockdust;
				
				totalDiamondsProduced = (randomDiamonds + itemsRandomDiamonds - diamondsDamaged);
				totalMarbleProduced = (randomMarble + itemsRandomMarble - marbleDamaged);
				totalGraniteProduced = (randomGranite + itemsRandomGranite - graniteDamaged);
				totalLimestoneProduced = (randomLimestone + itemsRandomLimestone - limestoneDamaged);
				totalRockdustProduced = (randomRockdust + itemsRandomRockdust - rockdustDamaged);
				
//------Subtract any resources lost due to disasters-----------------------------------------------
				if (fireDays > 0){
					setFireDamage(disasters.getFireDamage());
				}
				if (floodDays > 0){
					setFloodDamage(disasters.getFloodDamage());
				}
				if (internetDays > 0){
					setInternetDamage(disasters.getInternetDamage());
				}
				if (wifiDays > 0){
					setWifiDamage(disasters.getWifiDamage());
				}
				
//------Error checking if no resources are produced------------------------------------------------	
				if (resources.getTotalWorkers() == 0)
					{JOptionPane.showMessageDialog(null, "You must hire workers before you will produce anything", "No Workers!", JOptionPane.ERROR_MESSAGE);}
				
				if (totalDiamondsProduced + totalMarbleProduced + totalGraniteProduced + totalLimestoneProduced + totalRockdustProduced == 0)
					{JOptionPane.showMessageDialog(null, "Your quarries produced nothing this turn.", "No Production", JOptionPane.WARNING_MESSAGE);}
				
				else {
					
					String text = "";
					
// Concatenate texts together if resources were mined (don't give a message saying 0 diamonds were mined, 0 granite was mined, etc.)
					if (randomDiamonds > 0){
						text = text +  totalDiamondsProduced + " diamond";
						if (itemsRandomDiamonds > 0)
							{text = text + "  (+" + itemsRandomDiamonds + " due to items)";}
						if (diamondsDamaged > 0)
							{text = text + " (" + (diamondsDamaged/100) + " diamonds lost to disasters)";}
						text = text + "\n";
					}
					
					if (randomMarble > 0){
						text = text + totalMarbleProduced + " marble";
						if (itemsRandomMarble > 0)
							{text = text + "  (+" + itemsRandomMarble + " due to items)";}
						if (marbleDamaged > 0)
							{text = text + " (" + (marbleDamaged/100) + " marble lost to disasters)";}
						text = text + "\n";
					}
					
					if (randomGranite > 0){
						text = text + totalGraniteProduced + " granite";
						if (itemsRandomGranite > 0)
							{text = text + "  (+" + itemsRandomGranite + " due to items)";}
						if (graniteDamaged > 0)
							{text = text + " (" + (graniteDamaged/100) + " granite lost to disasters)";}
						text = text + "\n";
					}
					
					if (randomLimestone > 0){
						text = text + totalLimestoneProduced + " limestone";
						if (itemsRandomLimestone > 0)
							{text = text + "  (+" + itemsRandomLimestone + " due to items)";}
						if (limestoneDamaged > 0)
							{text = text + " (" + (limestoneDamaged/100) + " limestone lost to disasters)";}
						text = text + "\n";
					}
					
					if (randomRockdust > 0){
						text = text + totalRockdustProduced + " rock dust";
						if (itemsRandomRockdust > 0)
							{text = text + "  (+" + itemsRandomRockdust + " due to items)";}
						if (rockdustDamaged > 0)
							{text = text + " (" + (rockdustDamaged/100) + " rock dust lost to disasters)";}
					}
					
//------Make note of any further days of disaster in End of Turn screen------------------------
					if ((fireDays + floodDays + wifiDays + internetDays) > 0){
						
						text = text + "\n" + "\n";
						
						if (fireDays > 0){
							text = text + "Fires will rage for " + fireDays + " more days.";
						// Decrement the remaining days of the disaster left.
							fireDays = fireDays - 1;
							disasters.subtractFireDays(1);
						// Update the disaster statistics page with total number of days endured.
							stats.disasterStatistics.addFireDays(1);
						}
						if (floodDays > 0){
							text = text + "Heavy rains will end in " + floodDays + " days.";
						// Decrement the remaining days of the disaster.
							floodDays = floodDays - 1;
							disasters.subtractFloodDays(1);
						// Update the disaster statistics page with total number of days endured.
							stats.disasterStatistics.addFloodDays(1);
						}
						if (wifiDays > 0){
							text = text + "The WiFi will be fixed in " + wifiDays + " days.";
						// Decrement the remaining days of the disaster left.
							wifiDays = wifiDays - 1;
							disasters.subtractWifiDays(1);
						// Update the disaster statistics page with total number of days endured.
							stats.disasterStatistics.addWifiDays(1);
						}
						if (internetDays > 0){
							text = text + "The internet will be down for " + internetDays + " more days.";
						// Decrement the remaining days of the disaster left.
							internetDays = internetDays - 1;
							disasters.subtractInternetDays(1);
						// Update the disaster statistics page with total number of days endured.
							stats.disasterStatistics.addInternetDays(1);
						}
					}
				
					JOptionPane.showMessageDialog(null, "You mined the following this turn: " + "\n" + text, "End of day " + days, JOptionPane.PLAIN_MESSAGE);
					
					resources.addDiamonds(totalDiamondsProduced);
					resources.addMarble(totalMarbleProduced);
					resources.addGranite(totalGraniteProduced);
					resources.addLimestone(totalLimestoneProduced);
					resources.addRockdust(totalRockdustProduced);
					
//------Update statistics by total amounts of resources produced------------------------------------
					stats.addDiamondsTotalProduced(totalDiamondsProduced);
					stats.addMarbleTotalProduced(totalMarbleProduced);
					stats.addGraniteTotalProduced(totalGraniteProduced);
					stats.addLimestoneTotalProduced(totalLimestoneProduced);
					stats.addRockdustTotalProduced(totalRockdustProduced);
					
//------Update statistics by amounts increased by automation item-----------------------------------
					stats.addDiamondsAutoIncreased(autoRandomDiamonds);
					stats.addMarbleAutoIncreased(autoRandomMarble);
					stats.addGraniteAutoIncreased(autoRandomGranite);
					stats.addLimestoneAutoIncreased(autoRandomLimestone);
					stats.addRockdustAutoIncreased(autoRandomRockdust);
					
//------Update statistics by amount increased by various other items--------------------------------
					stats.addRockdustDynamiteIncreased(dynamiteRandomRockdust);
					stats.addDiamondDrillIncreased(drillRandomDiamonds);
					
//------Update statistics by amount increased by all items
					stats.addDiamondItemsIncreased(itemsRandomDiamonds);
					stats.addMarbleItemsIncreased(itemsRandomMarble);
					stats.addGraniteItemsIncreased(itemsRandomGranite);
					stats.addLimestoneItemsIncreased(itemsRandomLimestone);
					stats.addRockdustItemsIncreased(itemsRandomRockdust);
					
//------Increment the number of days passed---------------------------------------------------------
					menuButton.remove(turns);
					days++;
					numDays = "Days: " + days + "  ";
					turns = new JLabel(numDays);
					menuButton.add(turns);
					mainWindow.revalidate();
					
					stats.updateStatistics();
					resources.moneyUpdate();
					resources.resourceUpdate();
					resources.workersUpdate();
					
				}
		    }
	//	 }
	//	, 0, 5000);
//	}

	//public void buttonStopAction(){
	//	if(timer!=null)
	//		{timer.cancel();}
	//}
	
//File->New resets all the resources, workers, and store purchases----------------------------------	
	public void mNewAction(){
		Object[] options = { "OK", "CANCEL" };
		int newGame = JOptionPane.showOptionDialog(null, "Warning: This will delete all of your current data. Continue?", "New Game?",
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		
		if (newGame == JOptionPane.OK_OPTION){
			resources.setMoney(5000.0);
			resources.setDiamonds(0);
			resources.setMarble(0);
			resources.setGranite(0);
			resources.setLimestone(0);
			resources.setRockdust(0);
			
			resources.setDiamondWorkers(0);
			resources.setMarbleWorkers(0);
			resources.setGraniteWorkers(0);
			resources.setLimestoneWorkers(0);
			resources.setRockdustWorkers(0);
			resources.setTotalWorkers(0);
		
			store.setDrillPurchased(false);
			store.setDynamitePurchased(false);
			store.setAutomationPurchased(false);
			store.setExtinguisherPurchased(false);
			store.setConnectorPurchased(false);
			store.setMixerPurchased(false);
			store.setTruckPurchased(false);
			inventory.numberItems = 0;
			
			stats.updateStatistics();
			
			days = 0;
		}
	}

//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mDiamondStatsAction(){
		diamondOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(stats.BuildGUI());
		stats.addDiamondWorkers(resources.getDiamondWorkers());
		stats.setDiamondRate(resources.getDiamondWorkers());
		stats.statsPanel.add(stats.diamondStatistics.BuildGUI());
		mainWindow.setTitle("Game Statistics");
		mainWindow.validate();
	}
	
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mMarbleStatsAction(){
		marbleOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(stats.BuildGUI());
		stats.addMarbleWorkers(resources.getMarbleWorkers());
		stats.setMarbleRate(resources.getMarbleWorkers());
		stats.statsPanel.add(stats.marbleStatistics.BuildGUI());
		mainWindow.setTitle("Game Statistics");
		mainWindow.validate();
	}
	
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mGraniteStatsAction(){
		graniteOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(stats.BuildGUI());
		stats.addGraniteWorkers(resources.getGraniteWorkers());
		stats.setGraniteRate(resources.getGraniteWorkers());
		stats.statsPanel.add(stats.graniteStatistics.BuildGUI());
		mainWindow.setTitle("Game Statistics");
		mainWindow.validate();
	}
	
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mLimestoneStatsAction(){
		limestoneOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(stats.BuildGUI());
		stats.addLimestoneWorkers(resources.getLimestoneWorkers());
		stats.setLimestoneRate(resources.getLimestoneWorkers());
		stats.statsPanel.add(stats.limestoneStatistics.BuildGUI());
		mainWindow.setTitle("Game Statistics");
		mainWindow.validate();
	}
	
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mRockdustStatsAction(){
		rockdustOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(stats.BuildGUI());
		stats.addRockdustWorkers(resources.getTotalWorkers());
		stats.setRockdustRate(resources.getTotalWorkers());
		stats.statsPanel.add(stats.rockdustStatistics.BuildGUI());
		mainWindow.setTitle("Game Statistics");
		mainWindow.validate();
	}
	
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mDisasterStatsAction(){
		disasterOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(stats.BuildGUI());
		stats.disasterStatistics.setFireChance(disasters.getFireChance());
		stats.disasterStatistics.setFloodChance(disasters.getFloodChance());
		stats.disasterStatistics.setInternetChance(disasters.getInternetChance());
		stats.disasterStatistics.setWifiChance(disasters.getWifiChance());
		stats.statsPanel.add(stats.disasterStatistics.BuildGUI());
		mainWindow.setTitle("Disaster Statistics");
		mainWindow.validate();
		}
	
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mTreasureStatsAction(){
		treasureOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(stats.BuildGUI());
		stats.treasureStatistics.setDiamondChance(treasures.getDiamondChance());
		stats.treasureStatistics.setFossilChance(treasures.getFossilChance());
		stats.treasureStatistics.setGoldChance(treasures.getGoldChance());
		stats.statsPanel.add(stats.treasureStatistics.BuildGUI());
		mainWindow.setTitle("Treasure Statistics");
		mainWindow.validate();
		}
	
//------If statements prevent menu buttons from causing errors when in other screens----------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void mStoreAction(){
		storeOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(store.BuildGUI());
		mainWindow.setTitle("Vulcan Store");
		mainWindow.validate();
		
//Ensure the buttons are still gone because they seem to reappear when set to invisible only in the store screen		
		if (store.dynamitePurchased())
			{store.buyDynamite.setVisible(false);}
		if (store.drillPurchased())
			{store.buyDrill.setVisible(false);}
		if (store.automationPurchased())
			{store.buyAutomation.setVisible(false);}
		if (store.extinguisherPurchased())
			{store.buyExtinguisher.setVisible(false);}
		if (store.connectorPurchased())
			{store.buyConnector.setVisible(false);}
		if (store.mixerPurchased())
			{store.buyMixer.setVisible(false);}
		if (store.truckPurchased())
			{store.buyTruck.setVisible(false);}
	}

//------If statements prevent menu buttons from causing errors when in other screens-----------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens-------
	public void mInventoryAction(){
		inventoryOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(inventory.BuildGUI());
		mainWindow.setTitle("Inventory");
		mainWindow.revalidate();
	}
	
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void buttonSellAction(){
		sellOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (sell.sellPanel != null)
			{sell.sellPanel.removeAll();}
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(sell.BuildSellScreen());
		mainWindow.setTitle("Sell");
		mainWindow.validate();
	}
		
//------'If' statements prevent menu buttons from causing errors when in other screens--------------
//--Invalidate and setContentPane keep graphical glitches from occurring when switching screens--------
	public void buttonBuyAction(){
		buyOpen = true;
		mainWindow.invalidate();
		mainWindow.remove(totalScreen);
		if (inventory.inventoryWindow != null)
			{mainWindow.remove(inventory.inventoryWindow);}
		if (store.storeWindow != null)
			{mainWindow.remove(store.storeWindow);}
		mainWindow.setContentPane(buy.BuildBuyScreen());
		mainWindow.setTitle("Buy");
		mainWindow.validate();
	}
	
//------All of the button methods for navigating the introduction screen------------------------------	
	public void mainNextAction(){
		introHowToPlayOpen = true;
		introMainOpen = false;
		intro.introScreen.removeAll();
		back.setVisible(true);
		mainWindow.add(intro.BuildHowGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("How to Play");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void howtoplayNextAction(){
		introStoreOpen = true;
		introHowToPlayOpen = false;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildStoreGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Store");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void howtoplayBackAction(){
		introHowToPlayOpen = false;
		introMainOpen = true;
		intro.introScreen.removeAll();
		back.setVisible(false);
		mainWindow.add(intro.BuildMainGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Introduction");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void storeNextAction(){
		introStatisticsOpen = true;
		introStoreOpen = false;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildStatsGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Statistics");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void storeBackAction(){
		introStoreOpen = false;
		introHowToPlayOpen = true;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildHowGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("How To Play");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	
	public void statsNextAction(){
		introChancesOpen = true;
		introStatisticsOpen = false;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildChancesGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Chances of Treasures/Disasters");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void statsBackAction(){
		introStatisticsOpen = false;
		introStoreOpen = true;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildStoreGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Statistics");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void chancesNextAction(){
		introGoalOpen = true;
		introChancesOpen = false;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildGoalGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Goal");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void chancesBackAction(){
		introChancesOpen = false;
		introStatisticsOpen = true;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildStatsGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Chances of Treasures/Disasters");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	
	public void goalNextAction(){
		introGoalOpen = false;
		mainWindow.remove(buttons);
		intro.introScreen.removeAll();
		mainWindow.setContentPane(BuildGameGUI());
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	public void goalBackAction(){
		introGoalOpen = false;
		introChancesOpen = true;
		intro.introScreen.removeAll();
		mainWindow.add(intro.BuildGoalGUI(), BorderLayout.CENTER);
		mainWindow.add(buttons, BorderLayout.SOUTH);
		mainWindow.setTitle("Goal");
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	
}
