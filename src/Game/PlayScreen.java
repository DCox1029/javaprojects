package Game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;


public class PlayScreen extends JPanel{
	
	private Image image;
	  
	public static void main(String args[]){
		new PlayScreen();
	}
	
	public PlayScreen(){
		image = Toolkit.getDefaultToolkit().createImage("C:/Users/coxda/Pictures/Wallpapers/Desert.jpg");
	}

	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, null);
	 }
	 
}
