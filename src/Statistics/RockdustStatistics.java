package Statistics;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RockdustStatistics extends JPanel {
	JPanel rockdustStatsWindow;
	JLabel workersLabel;
	JLabel rateLabel;
	JLabel producedLabel;
	JLabel earnedLabel;
	JLabel autoLabel;
	JLabel dynamiteLabel;
	JLabel itemsLabel;
	JLabel title;

	private int workers = 0;
	private int rate = 0;
	private int totalProduced = 0;
	private int autoIncreased = 0;
	private int dynamiteIncreased = 0;
	private int itemsIncreased = 0;
	private double totalEarned = 0;
	
	DecimalFormat moneyFormat = new DecimalFormat("#.##");
	
	public JPanel BuildGUI(){
		rockdustStatsWindow = new JPanel();
		
//
		workersLabel = new JLabel("<html>Total Number of Workers: " + workers + " </html>");
		rateLabel = new JLabel("<html>Average Per Turn: " + rate + " tons</html>");
		autoLabel = new JLabel("<html>Automated Plants Contribution: " + autoIncreased + " tons</html>");
		dynamiteLabel = new JLabel("<html>Dynamite Contribution " + dynamiteIncreased + " tons</html>");
		itemsLabel = new JLabel ("<html>Purchased Items Contribution: " + itemsIncreased + " tons</html>");
		producedLabel = new JLabel("<html>Total Rock Dust Production: " + totalProduced + " tons</html>");
		earnedLabel = new JLabel("<html>Total Rock Dust Sales: $" + moneyFormat.format(totalEarned) + "</html>");
		title = new JLabel("<html>Rock Dust Stats:</html>", JLabel.CENTER);
		
//------Font Adjustments---------------------------------------------------------------------------
		workersLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		rateLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		autoLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		dynamiteLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		itemsLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		producedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		earnedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		title.setFont(new Font("Verdana", Font.BOLD, 12));
				
		rockdustStatsWindow.add(title);
		rockdustStatsWindow.add(workersLabel);
		rockdustStatsWindow.add(rateLabel);
		rockdustStatsWindow.add(dynamiteLabel);
		rockdustStatsWindow.add(autoLabel);
		rockdustStatsWindow.add(itemsLabel);
		rockdustStatsWindow.add(producedLabel);
		rockdustStatsWindow.add(earnedLabel);
		
		rockdustStatsWindow.setLayout(new BoxLayout(rockdustStatsWindow, BoxLayout.PAGE_AXIS));
		
		return rockdustStatsWindow;
	}
	
	public void setRate(int Workers)
		{rate = Workers*14;}
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
	public void addAutoIncreased(int autoRockdust)
		{autoIncreased = autoIncreased + autoRockdust;}
	public void addDynamiteIncreased(int dynamiteRockdust)
		{dynamiteIncreased = dynamiteIncreased + dynamiteRockdust;}
	public void addTotalEarned(double rockdustEarned)
		{totalEarned = totalEarned + rockdustEarned;}
}
