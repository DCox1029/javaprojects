package Introduction;

import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlay {
	JPanel howToPlayScreen;
	
	JLabel overview;
	JLabel resources;
	JLabel money;
	JLabel workers;
	JLabel sell;
	
	public JPanel BuildGUI(){
		howToPlayScreen = new JPanel();
		
		overview = new JLabel("<html>Mining Operations is a turn-based game where each day you produce different minerals</html>");
		resources = new JLabel("<html>You can mine diamonds, marble, granite, and limestone.</html>");
		sell = new JLabel ("<html>Sell your resources to increase your money.</html>");
		money = new JLabel ("<html>Use money to buy items or more workers.</html>");
		workers = new JLabel ("<html>The amount of resources you produce depends on the number of workers you have. Each worker will produce his/her respective mineral as well as a large amount of rock dust.</html>");
		
		howToPlayScreen.add(overview);
		howToPlayScreen.add(resources);
		howToPlayScreen.add(sell);
		howToPlayScreen.add(money);
		howToPlayScreen.add(workers);
		howToPlayScreen.setLayout(new BoxLayout(howToPlayScreen, BoxLayout.PAGE_AXIS));
		
		return howToPlayScreen;
	}
}
