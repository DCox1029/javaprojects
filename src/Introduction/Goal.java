package Introduction;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Goal {
	JPanel goalScreen;
	
	JButton next;
	
	public JPanel BuildGUI(){
		goalScreen = new JPanel();
		next = new JButton("NEXT");
		
		return goalScreen;
	}
	
	public void actionPerformed(ActionEvent A){
		Object source = A.getSource();
		
		if(source == next)
			{next();}
	}
	
	public void next(){
		
	}
}
