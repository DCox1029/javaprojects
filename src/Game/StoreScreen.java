package Game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import Inventory.*;
import Inventory.Surveyors;
import ItemPages.*;

public class StoreScreen implements ActionListener{
	JPanel storeWindow;
	JPanel itemsPanel;
	JButton buttonBack;
	
	JPanel productionItems;
	JPanel disasterItems;
	JPanel treasureItems;
	
	JPanel productionItemsPanel;
	JPanel disasterItemsPanel;
	JPanel treasureItemsPanel;
	
	JLabel labelProduction;
	JLabel labelDisaster;
	JLabel labelTreasure;
	
	public JButton buyDynamite;
	public JButton buyAutomation;
	public JButton buyExtinguisher;
	public JButton buyConnector;
	public JButton buyMixer;
	public JButton buyTruck;
	public JButton buyDrill;
	public JButton buyIntern;
	public JButton buySurveyor;
	JLabel moneyLabel;
	
	DecimalFormat moneyFormat;
	
	private Automation auto = new Automation();
	private FireExtinguisher fireExtinguisher = new FireExtinguisher();
	private DiamondDrillbit dDrill = new DiamondDrillbit();
	private Dynamite dynamite = new Dynamite();
	private FCConnector connector = new FCConnector();
	private CementMixer mixer = new CementMixer();
	private DumpTruck truck = new DumpTruck();
	private NetworkInterns interns = new NetworkInterns();
	private Surveyors surveyors = new Surveyors();
	
	private DiamondDrillbitPage ddPage = new DiamondDrillbitPage();
	private CementMixerPage cmPage = new CementMixerPage();
	private AutomationPage aPage = new AutomationPage();
	private DumpTruckPage dtPage = new DumpTruckPage();
	private DynamitePage dyPage = new DynamitePage();
	private FCConnectorPage fcPage = new FCConnectorPage();
	private FireExtinguisherPage fePage = new FireExtinguisherPage();
	private NetworkInternsPage niPage = new NetworkInternsPage();
	private SurveyorsPage sPage = new SurveyorsPage();
	
	public JPanel BuildGUI(){
		storeWindow = new JPanel();
		itemsPanel = new JPanel();
		
		productionItems = new JPanel();
		treasureItems = new JPanel();
		disasterItems = new JPanel();
		
		productionItemsPanel = new JPanel();
		treasureItemsPanel = new JPanel();
		disasterItemsPanel = new JPanel();
		
		labelProduction = new JLabel("Production Increase: ");
		labelDisaster = new JLabel("Disaster Prevention: ");
		labelTreasure = new JLabel("Luck: ");

//------Round Doubles to Hundreds Place-----------------------------------------------------------
		moneyFormat = new DecimalFormat("#.##");
		moneyLabel = new JLabel("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
//------Button for Buying Diamond Tipped Drill Bits-------------------------------------------------------------		
		buyDrill = new JButton();
		JLabel ddName = new JLabel("Drill Tips");
		ddName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyDrill.add(ddName);
		
//------Button for Buying Cement Mixer-------------------------------------------------------------		
		buyMixer = new JButton();
		JLabel mName = new JLabel("Mixers");
		mName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyMixer.add(mName);
		
//------Button for Buying Automation-------------------------------------------------------------		
		buyAutomation = new JButton();
		JLabel aName = new JLabel("Automation");
		aName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyAutomation.add(aName);
		
//------Button for Buying Dump Trucks-------------------------------------------------------------		
		buyTruck = new JButton();
		JLabel tName = new JLabel("Trucks");
		tName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyTruck.add(tName);
		
//------Button for Buying Dynamite-------------------------------------------------------------		
		buyDynamite = new JButton();
		JLabel dyName = new JLabel("Dynamite");
		dyName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyDynamite.add(dyName);
		
//------Button for FC Connectors-------------------------------------------------------------		
		buyConnector = new JButton();
		JLabel cName = new JLabel("Cables");
		cName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyConnector.add(cName);
		
//------Button for Fire Extinguishers-------------------------------------------------------------		
		buyExtinguisher = new JButton();
		JLabel feName = new JLabel("Firefighting");
		feName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyExtinguisher.add(feName);
		
//------Button for Hiring Interns-------------------------------------------------------------		
		buyIntern = new JButton();
		JLabel niName = new JLabel("Interns");
		niName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buyIntern.add(niName);
		
//------Button for Hiring Surveyors-------------------------------------------------------------		
		buySurveyor = new JButton();
		JLabel sName = new JLabel("Surveyors");
		sName.setAlignmentX(Component.CENTER_ALIGNMENT);
		buySurveyor.add(sName);
		
//------Back button-------------------------------------------------------------------------------
		buttonBack = new JButton ("BACK");
		buttonBack.addActionListener(this);
		
//------Panel for Production Items-----------------------------------------------------------------
		productionItemsPanel.setLayout(new GridLayout(0,2));
		productionItemsPanel.add(buyAutomation);
		productionItemsPanel.add(buyDrill);
		productionItemsPanel.add(buyDynamite);
		productionItemsPanel.add(buyMixer);
		productionItemsPanel.add(buyTruck);
		
		productionItems.setLayout(new BorderLayout());
		productionItems.add(labelProduction, BorderLayout.NORTH);
		productionItems.add(productionItemsPanel, BorderLayout.CENTER);
		
//------Panel for Disaster Items-----------------------------------------------------------------
		disasterItemsPanel.setLayout(new GridLayout(0,2));
		disasterItemsPanel.add(buyExtinguisher);
		disasterItemsPanel.add(buyConnector);
		disasterItemsPanel.add(buyIntern);
		
		disasterItems.setLayout(new BorderLayout());
		disasterItems.add(labelDisaster, BorderLayout.NORTH);
		disasterItems.add(disasterItemsPanel, BorderLayout.CENTER);
		
//------Panel for Treasure Items-----------------------------------------------------------------
		treasureItemsPanel.setLayout(new GridLayout(0,2));
		treasureItemsPanel.add(buySurveyor);
		
		treasureItems.setLayout(new BorderLayout());
		treasureItems.add(labelTreasure, BorderLayout.NORTH);
		treasureItems.add(treasureItemsPanel, BorderLayout.CENTER);
		
//------Action Listeners for buttons------------------------------------------------------------------
		buyDrill.addActionListener(this);
		buyDynamite.addActionListener(this);
		buyAutomation.addActionListener(this);
		buyExtinguisher.addActionListener(this);
		buyConnector.addActionListener(this);
		buyMixer.addActionListener(this);
		buyTruck.addActionListener(this);
		buyIntern.addActionListener(this);
		buySurveyor.addActionListener(this);
		
		itemsPanel.setLayout(new BorderLayout());
		itemsPanel.add(productionItems, BorderLayout.NORTH);
		itemsPanel.add(disasterItems, BorderLayout.SOUTH);
		itemsPanel.add(treasureItems, BorderLayout.CENTER);
		
		storeWindow.setLayout(new BorderLayout());
		storeWindow.add(moneyLabel, BorderLayout.SOUTH);
		storeWindow.add(itemsPanel, BorderLayout.CENTER);
		storeWindow.add(buttonBack, BorderLayout.NORTH);
		
		return storeWindow;
	}
	
	public void updateMoney(){
		storeWindow.remove(moneyLabel);
		moneyLabel.setText("Money: $" + moneyFormat.format(VMGame.resources.getMoney()));
		storeWindow.add(moneyLabel, BorderLayout.SOUTH);
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		storeWindow.revalidate();
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
	
//------Assign methods to buttons---------------------------------------------------------------
		if(source == buttonBack)
			{backButton();}
		if(source == buyDynamite)
			{dynamiteBuy();}
		if(source == buyAutomation)
			{automationBuy();}
		if(source == buyDrill)
			{drillBuy();}
		if(source == buyExtinguisher)
			{extinguisherBuy();}
		if(source == buyConnector)
			{connectorBuy();}
		if(source == buyTruck)
			{truckBuy();}
		if(source == buyMixer)
			{mixerBuy();}
		if(source == buyIntern)
			{internBuy();}
		if(source == buySurveyor)
			{surveyorBuy();}
	}
	
//------Methods for the buttons------------------------------------------------------------------
	public void backButton(){
		VMGame.storeOpen = false;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(VMGame.totalScreen);
		VMGame.mainWindow.setTitle("Vulcan Materials: Mining Operations");
		VMGame.mainWindow.revalidate();
	}
	public void drillBuy(){
		VMGame.storeOpen = false;
		VMGame.ddOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(ddPage.BuildDrillPage());
		VMGame.mainWindow.setTitle("Diamond Tipped Drill");
		VMGame.mainWindow.revalidate();
	}
	public void mixerBuy(){
		VMGame.storeOpen = false;
		VMGame.mixerOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(cmPage.BuildMixerPage());
		VMGame.mainWindow.setTitle("Cement Mixers");
		VMGame.mainWindow.revalidate();
	}
	public void automationBuy(){
		VMGame.storeOpen = false;
		VMGame.automationOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(aPage.BuildAutoPage());
		VMGame.mainWindow.setTitle("Automated Assembly Line");
		VMGame.mainWindow.revalidate();
	}
	public void truckBuy(){
		VMGame.storeOpen = false;
		VMGame.truckOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(dtPage.BuildTruckPage());
		VMGame.mainWindow.setTitle("Super Dump Trucks");
		VMGame.mainWindow.revalidate();
	}
	public void dynamiteBuy(){
		VMGame.storeOpen = false;
		VMGame.dynamiteOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(dyPage.BuildDynamitePage());
		VMGame.mainWindow.setTitle("High Yield Dynamite");
		VMGame.mainWindow.revalidate();
	}
	public void connectorBuy(){
		VMGame.storeOpen = false;
		VMGame.connectorOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(fcPage.BuildConnectorPage());
		VMGame.mainWindow.setTitle("FC Connectors");
		VMGame.mainWindow.revalidate();
	}
	public void extinguisherBuy(){
		VMGame.storeOpen = false;
		VMGame.extinguisherOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(fePage.BuildExtinguisherPage());
		VMGame.mainWindow.setTitle("Fire Extinguishers");
		VMGame.mainWindow.revalidate();
	}
	public void internBuy(){
		VMGame.storeOpen = false;
		VMGame.internOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(niPage.BuildInternsPage());
		VMGame.mainWindow.setTitle("Network Interns");
		VMGame.mainWindow.revalidate();
	}
	public void surveyorBuy(){
		VMGame.storeOpen = false;
		VMGame.surveyorOpen = true;
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.remove(storeWindow);
		VMGame.mainWindow.revalidate();
		VMGame.mainWindow.setContentPane(sPage.BuildSurveyorsPage());
		VMGame.mainWindow.setTitle("Mineral Surveyors");
		VMGame.mainWindow.revalidate();
	}
	
//------Set whether or not the item is already purchased-------------------------------------------
	public void setDrillPurchased(boolean set)
		{dDrill.setPurchased(set);}
	public void setDynamitePurchased(boolean set)
		{dynamite.setPurchased(set);}
	public void setAutomationPurchased(boolean set)
		{auto.setPurchased(set);}
	public void setExtinguisherPurchased(boolean set)
		{fireExtinguisher.setPurchased(set);}
	public void setConnectorPurchased(boolean set)
		{connector.setPurchased(set);}
	public void setTruckPurchased(boolean set)
		{truck.setPurchased(set);}
	public void setMixerPurchased(boolean set)
		{mixer.setPurchased(set);}
	public void setInternsPurchased(boolean set)
		{interns.setPurchased(set);}
	public void setSurveyorsPurchased(boolean set)
		{surveyors.setPurchased(set);}
	
//------Get whether or not the item is already purchased-----------------------------------------
	public boolean drillPurchased()
		{return dDrill.getPurchased();}
	public boolean dynamitePurchased()
		{return dynamite.getPurchased();}
	public boolean automationPurchased()
		{return auto.getPurchased();}
	public boolean extinguisherPurchased()
		{return fireExtinguisher.getPurchased();}
	public boolean connectorPurchased()
		{return connector.getPurchased();}
	public boolean truckPurchased()
		{return truck.getPurchased();}
	public boolean mixerPurchased()
		{return mixer.getPurchased();}
	public boolean internsPurchased()
		{return interns.getPurchased();}
	public boolean surveyorsPurchased()
		{return surveyors.getPurchased();}
	
	public void updateStore(){
		if (storeWindow!=null){
			if (VMGame.storeOpen){
				storeWindow.revalidate();
				VMGame.mainWindow.remove(storeWindow);
				storeWindow.repaint();
				VMGame.mainWindow.setContentPane(BuildGUI());
				storeWindow.revalidate();}
		}
	}

}
