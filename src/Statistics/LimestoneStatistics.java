package Statistics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LimestoneStatistics extends JPanel {
	JPanel limestoneStatsWindow;
	JLabel workersLabel;
	JLabel rateLabel;
	JLabel producedLabel;
	JLabel earnedLabel;
	JLabel autoLabel;
	JLabel itemsLabel;
	JLabel title;
	
	private int workers;
	private int rate;
	private int totalProduced = 0;
	private int autoIncreased = 0;
	private int itemsIncreased = 0;
	private double totalEarned;
	
	DecimalFormat moneyFormat = new DecimalFormat("#.##");
	
	public JPanel BuildGUI(){
		limestoneStatsWindow = new JPanel();
		
		
//------Labels------------------------------------------------------------------------------------------
		workersLabel = new JLabel("<html>Total Number of Limestone Workers: " + workers + "<br></br></html>");
		rateLabel = new JLabel("<html>Average Per Turn: " + rate + " tons</html>");
		autoLabel = new JLabel("<html>Automated Plants Contribution: " + autoIncreased + " tons</html>");
		itemsLabel = new JLabel ("<html>Purchased Items Contribution: " + itemsIncreased + " tons</html>");
		producedLabel = new JLabel("<html>Total Limestone Production: " + totalProduced + " tons</html>");
		earnedLabel = new JLabel("<html>Total Limestone Sales: $" + moneyFormat.format(totalEarned) + "</html>");
		title = new JLabel("<html>Limestone Stats:</html>", JLabel.CENTER);
						
//------Font Adjustments---------------------------------------------------------------------------
		workersLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		rateLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		autoLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		itemsLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		producedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		earnedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		title.setFont(new Font("Verdana", Font.BOLD, 12));
		
		limestoneStatsWindow.add(title);
		limestoneStatsWindow.add(workersLabel);
		limestoneStatsWindow.add(rateLabel);
		limestoneStatsWindow.add(autoLabel);
		limestoneStatsWindow.add(itemsLabel);
		limestoneStatsWindow.add(producedLabel);
		limestoneStatsWindow.add(earnedLabel);
		
		limestoneStatsWindow.setLayout(new BoxLayout(limestoneStatsWindow, BoxLayout.PAGE_AXIS));
		
		return limestoneStatsWindow;
	}
	
	public void setRate(int Workers)
		{rate = Workers*6;}
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
	public void addAutoIncreased(int autoLimestone)
		{autoIncreased = autoIncreased + autoLimestone;}
	public void addTotalEarned(double limestoneEarned)
		{totalEarned = totalEarned + limestoneEarned;}
}
