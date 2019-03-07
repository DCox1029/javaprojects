package Introduction;

import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Store {
	JPanel storeScreen;
	JLabel resourceStats;
	JLabel disasterStats;
	JLabel statsMenu;
	
	public JPanel BuildGUI(){
		storeScreen = new JPanel();
		
		statsMenu = new JLabel("<html>At the top of the game screen there is a statistics button which will display various statistics about the game so far./html>");
		resourceStats = new JLabel("<html>You can see how many workers you have, how many resources you produce per turn, the amount of resources your items have contributed, and the amount of money you've made with that resource.</html>");
		disasterStats = new JLabel("<html>There are also statistics for disastsers, including the amount of resources lost and number of days experiencing that particular disaster.</html>");
		
		storeScreen.add(statsMenu);
		storeScreen.add(resourceStats);
		storeScreen.add(disasterStats);
		storeScreen.setLayout(new BoxLayout(storeScreen, BoxLayout.PAGE_AXIS));
		
		return storeScreen;
	}
}
