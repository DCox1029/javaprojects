package Introduction;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainScreen {
	private JPanel mainScreen;
	
	JLabel title1;
	JLabel title2;
	JLabel title3;
	JLabel welcome;
	
	public JPanel BuildGUI(){
		mainScreen = new JPanel();
		
		title1 = new JLabel("<html><h3> Welcome to Vulcan Materials: Mining Operations!<BR></html></h3>", JLabel.CENTER);
		title2 = new JLabel("<html> This game will give you a glimpse as to what it's like being the nation's largest producer of construction aggregate.</html>");
		title3 = new JLabel("<html> In this game you will learn to manage your money, hire workers, and buy items so that you can increase your production of valuable minerals and maximize profit.</html>");
		
		title2.setFont(new Font("Verdana", Font.PLAIN, 10));
		title3.setFont(new Font("Verdana", Font.PLAIN, 10));
		
		mainScreen.add(title1);
		mainScreen.add(title2);
		mainScreen.add(title3);
		mainScreen.setLayout(new BoxLayout(mainScreen, BoxLayout.PAGE_AXIS));

		return mainScreen;
		
	}
	
	public void removeGUI(){
		mainScreen.remove(mainScreen);
	}
	
}
