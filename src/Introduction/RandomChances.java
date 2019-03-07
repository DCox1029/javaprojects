package Introduction;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RandomChances {
	JPanel chancesScreen;
	
	JButton next;
	
	public JPanel BuildGUI(){
		chancesScreen = new JPanel();
		next = new JButton("NEXT");
		
		return chancesScreen;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == next)
			{next();}
	}
	
	public void next(){
		
	}
}
