package Game;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InventoryScreen implements ActionListener{
	JPanel inventoryWindow;
	public JPanel itemsPanel;
	
	JButton buttonBack;
	
	JLabel drill;
	JLabel dynamite;
	JLabel automation;
	JLabel extinguisher;
	JLabel connector;
	JLabel truck;
	JLabel mixer;
	
	JLabel numItems;
	
	public int numberItems;
	
	public JPanel BuildGUI(){
		inventoryWindow = new JPanel();
		itemsPanel = new JPanel();
		itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.PAGE_AXIS));
		
		drill = new JLabel("<html> Drill Bits: Diamonds +25%</html>");
		dynamite = new JLabel("<html> Dynamite: Rock Dust x2</html>");
		automation = new JLabel("<html> Automation: All +50%</html>");
		extinguisher = new JLabel("<html> Fire Extinguisher: Fires -12%</html>");
		connector = new JLabel("<html> FC Connectors: Internet Out -9%</html>");
		truck = new JLabel ("<html> Dump Trucks: Sell All Resources</html>");
		mixer = new JLabel ("<html> Cement Mixers: Rock Dust +$0.2</html>");
		
		if (VMGame.store.drillPurchased()){
			itemsPanel.add(drill);
			numberItems++;
		}
		if (VMGame.store.dynamitePurchased()){
			itemsPanel.add(dynamite);
			numberItems++;
		}
		if (VMGame.store.automationPurchased()){
			itemsPanel.add(automation);
			numberItems++;
		}
		if (VMGame.store.extinguisherPurchased()){
			itemsPanel.add(extinguisher);
			numberItems++;
		}
		if (VMGame.store.connectorPurchased()){
			itemsPanel.add(connector);
			numberItems++;
		}
		if (VMGame.store.truckPurchased()){
			itemsPanel.add(truck);
			numberItems++;
		}
		if (VMGame.store.mixerPurchased()){
			itemsPanel.add(mixer);
			numberItems++;
		}
		
		numItems = new JLabel("Items: " + numberItems);
		numItems.setHorizontalAlignment(SwingConstants.CENTER);
		
		buttonBack = new JButton ("BACK");
		buttonBack.addActionListener(this);
		
		inventoryWindow.setLayout(new BorderLayout());
		inventoryWindow.add(numItems, BorderLayout.SOUTH);
		inventoryWindow.add(itemsPanel, BorderLayout.CENTER);
		inventoryWindow.add(buttonBack, BorderLayout.NORTH);
		
		return inventoryWindow;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == buttonBack)
			{backButton();}
	}
	
	public void backButton(){
		VMGame.inventoryOpen = false;
		VMGame.mainWindow.invalidate();
		VMGame.mainWindow.remove(inventoryWindow);
		VMGame.fileMenu.setEnabled(true);
		VMGame.storeMenu.setEnabled(true);
		VMGame.mainWindow.setContentPane(VMGame.totalScreen);
		VMGame.mainWindow.setTitle("Vulcan Materials Game");
		VMGame.mainWindow.validate();
	}
}

