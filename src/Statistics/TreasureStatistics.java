package Statistics;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TreasureStatistics {
	public JPanel treasureStatsWindow;
	JPanel chance;
	JPanel gained;
	
	JLabel title;
	
	JLabel dGained;
	JLabel fmGained;
	JLabel gmGained;
	
	JLabel dChance;
	JLabel fChance;
	JLabel gChance;
	
	JLabel divider1 = new JLabel (" ");
	
	private int fossilChance;
	private int diamondChance;
	private int goldChance;
	
	private int diamondsGained;
	private double fossilMoneyEarned;
	private double goldMoneyEarned;
	
	
	public JPanel BuildGUI(){
		treasureStatsWindow = new JPanel();
		chance = new JPanel();
		gained = new JPanel();
		
//------Labels--------------------------------------------------------------------------------------------
		title = new JLabel("<html>Treasure Stats:</html>", JLabel.CENTER);
				
		dGained = new JLabel("Diamonds found: " + diamondsGained);
		fmGained = new JLabel("Money from Fossils: $" + fossilMoneyEarned);
		gmGained = new JLabel("Money from Gold: $" + goldMoneyEarned);
			
		dChance = new JLabel("<html>Chance for Diamond Veins: " + diamondChance + "%.</html>");
		fChance = new JLabel("<html>Chance for Fossils: " + fossilChance + "%.</html>");
		gChance = new JLabel("<html>Chance for Gold Veins: " + goldChance + "%.</html>");
			
//------Font Adjustments---------------------------------------------------------------------------
		dGained.setFont(new Font("Verdana", Font.PLAIN, 9));
		fmGained.setFont(new Font("Verdana", Font.PLAIN, 9));
		gmGained.setFont(new Font("Verdana", Font.PLAIN, 9));
		
		dChance.setFont(new Font("Verdana", Font.PLAIN, 9));
		fChance.setFont(new Font("Verdana", Font.PLAIN, 9));
		gChance.setFont(new Font("Verdana", Font.PLAIN, 9));
		
		title.setFont(new Font("Verdana", Font.BOLD, 12));
		
//------Add the Labels to the Window----------------------------------------------------------------
		treasureStatsWindow.add(title);
				
		treasureStatsWindow.add(fChance);
		treasureStatsWindow.add(gChance);
		treasureStatsWindow.add(dChance);
		
		treasureStatsWindow.add(divider1);
		
		treasureStatsWindow.add(fmGained);
		treasureStatsWindow.add(gmGained);
		treasureStatsWindow.add(dGained);
		
		treasureStatsWindow.setLayout(new BoxLayout(treasureStatsWindow, BoxLayout.PAGE_AXIS));
		
		return treasureStatsWindow;
	}
	
	public int getDiamondsGained()
		{return diamondsGained;}
	public double getFossilMoneyEarned()
		{return fossilMoneyEarned;}
	public double getGoldMoneyEarned()
		{return goldMoneyEarned;}
	
	public void addDiamondsGained(int dGained)
		{diamondsGained = diamondsGained + dGained;}
	public void addFossilMoneyEarned(double fmGained)
		{fossilMoneyEarned = fossilMoneyEarned + fmGained;}
	public void addGoldMoneyEarned(double gmGained)
		{goldMoneyEarned = goldMoneyEarned + gmGained;}
	
	public int getDiamondChance()
		{return diamondChance;}
	public int getFossilChance()
		{return fossilChance;}
	public int getGoldChance()
		{return goldChance;}
	
	public void setDiamondChance(int dChance)
		{diamondChance = dChance;}
	public void setFossilChance(int fChance)
		{fossilChance = fChance;}
	public void setGoldChance(int gChance)
		{goldChance = gChance;}
}
