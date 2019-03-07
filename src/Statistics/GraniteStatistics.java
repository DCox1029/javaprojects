package Statistics;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraniteStatistics extends JPanel {
	JPanel graniteStatsWindow;
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
		graniteStatsWindow = new JPanel();
		
//------Labels------------------------------------------------------------------------------------------
		workersLabel = new JLabel("<html>Total Number of Granite Workers: " + workers + "<br></br></html>");
		rateLabel = new JLabel("<html>Average Per Turn: " + rate + " tons</html>");
		autoLabel = new JLabel("<html>Automated Plants Contribution: " + autoIncreased + " tons</html>");
		itemsLabel = new JLabel ("<html>Purchased Items Contribution: " + itemsIncreased + " tons</html>");
		producedLabel = new JLabel("<html>Total Granite Production: " + totalProduced + " tons</html>");
		earnedLabel = new JLabel("<html>Total Granite Sales: $" + moneyFormat.format(totalEarned) + "</html>");
		title = new JLabel("<html>Granite Stats:</html>", JLabel.CENTER);
				
//------Font Adjustments---------------------------------------------------------------------------
		workersLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		rateLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		autoLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		itemsLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		producedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		earnedLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		title.setFont(new Font("Verdana", Font.BOLD, 12));
				
		graniteStatsWindow.add(title);
		graniteStatsWindow.add(workersLabel);
		graniteStatsWindow.add(rateLabel);
		graniteStatsWindow.add(autoLabel);
		graniteStatsWindow.add(itemsLabel);
		graniteStatsWindow.add(producedLabel);
		graniteStatsWindow.add(earnedLabel);
		
		graniteStatsWindow.setLayout(new BoxLayout(graniteStatsWindow, BoxLayout.PAGE_AXIS));
		
		return graniteStatsWindow;
	}
	
	public void setRate(int Workers)
		{rate = Workers*4;}
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
	public void addAutoIncreased(int autoGranite)
		{autoIncreased = autoIncreased + autoGranite;}
	public void addTotalEarned(double graniteEarned)
		{totalEarned = totalEarned + graniteEarned;}
}
