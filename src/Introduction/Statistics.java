package Introduction;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Statistics {
	JPanel statsScreen;
	
	JButton next;
	
	public JPanel BuildGUI(){
		statsScreen = new JPanel();
		next = new JButton("NEXT");
		
		return statsScreen;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == next)
			{next();}
	}
	
	public void next(){
		
	}
}
