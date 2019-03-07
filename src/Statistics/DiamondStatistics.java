package Statistics;

import java.awt.Font;
import java.awt.TextArea;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DiamondStatistics extends JPanel {
	public JPanel diamondStatsWindow;
	JLabel titleLabel;
	JLabel workersLabel;
	JLabel rateLabel;
	JLabel producedLabel;
	JLabel earnedLabel;
	JLabel drillLabel;
	JLabel autoLabel;
	JLabel itemsLabel;
	
	private double totalEarned;
	private int workers;
	private int rate;
	private int totalProduced = 0;
	private int autoIncreased = 0;
	private int drillIncreased = 0;
	private int itemsIncreased = 0;
	
	DecimalFormat moneyFormat = new DecimalFormat("#.##");
	
	public JPanel BuildGUI(){
		diamondStatsWindow = new JPanel();
	
//------Labels------------------------------------------------------------------------------------------
		workersLabel = new JLabel("<html>Total Number of Diamond Workers: " + workers + "<br></br></html>");
		rateLabel = new JLabel("<html>Average Per Turn: " + rate + " tons</html>");
		drillLabel = new JLabel("<html>Diamond Drill Tips Contribution: " + drillIncreased + " tons</html>");
		autoLabel = new JLabel("<html>Automated Plants Contribution: " + autoIncreased + " tons</html>");
		itemsLabel = new JLabel ("<html>Purchased Items Contribution: " + itemsIncreased + " tons</html>");
		producedLabel = new JLabel("<html>Total Diamond Production: " + totalProduced + " tons</html>");
		earnedLabel = new JLabel("<html>Total Diamond Sales: $" + moneyFormat.format(totalEarned) + "</html>");
		titleLabel = new JLabel("<html>Diamond Stats:</html>", JLabel.CENTER);
		
//------Font Adjustments---------------------------------------------------------------------------
		workersLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		rateLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		drillLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		autoLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		itemsLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		producedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		earnedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		diamondStatsWindow.add(titleLabel);
		diamondStatsWindow.add(workersLabel);
		diamondStatsWindow.add(rateLabel);
		diamondStatsWindow.add(drillLabel);
		diamondStatsWindow.add(autoLabel);
		diamondStatsWindow.add(itemsLabel);
		diamondStatsWindow.add(producedLabel);
		diamondStatsWindow.add(earnedLabel);
		
		diamondStatsWindow.setLayout(new BoxLayout(diamondStatsWindow, BoxLayout.PAGE_AXIS));
		
		return diamondStatsWindow;
	}
	
	public void setRate(int Workers)
		{rate = Workers*1;}
	public void setWorkers(int Workers)
		{workers = workers + Workers;}
		
	public int getRate()
		{return rate;}
	public int getWorkers()
		{return workers;}
	public int getTotalProduced()
		{return totalProduced;}
	
	public void addTotalProduced(int produced)
		{totalProduced = totalProduced + produced;}
	public void addItemsIncreased(int itemAmount)
		{itemsIncreased = itemsIncreased + itemAmount;}
	public void addAutoIncreased(int autoDiamond)
		{autoIncreased = autoIncreased + autoDiamond;}
	public void addDrillIncreased(int drillDiamond)
		{drillIncreased = drillIncreased + drillDiamond;}
	public void addTotalEarned(double diamondEarned)
		{totalEarned = totalEarned + diamondEarned;}
}
