package Statistics;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisasterStatistics extends JPanel {
	public JPanel disasterStatsWindow;
	JPanel chance;
	JPanel lost;
	JPanel days;
	
	JLabel title;
	
	JLabel dLost;
	JLabel mLost;
	JLabel gLost;
	JLabel lLost;
	
	JLabel fiDays;
	JLabel flDays;
	JLabel iDays;
	JLabel wDays;
	
	JLabel fiChance;
	JLabel flChance;
	JLabel iChance;
	JLabel wChance;
	
	JLabel divider1 = new JLabel (" ");
	JLabel divider2 = new JLabel (" ");
	
	private int totalDiamondsLost;
	private int totalMarbleLost;
	private int totalGraniteLost;
	private int totalLimestoneLost;
	
	private int fireDays;
	private int floodDays;
	private int internetDays;
	private int wifiDays;
	
	private int fireChance;
	private int floodChance;
	private int internetChance;
	private int wifiChance;
	
	public JPanel BuildGUI(){
		disasterStatsWindow = new JPanel();
		chance = new JPanel();
		lost = new JPanel();
		days = new JPanel();
		
//------Labels--------------------------------------------------------------------------------------------
		title = new JLabel("<html>Disaster Stats:</html>", JLabel.CENTER);
		
		dLost = new JLabel("Total diamonds lost: " + totalDiamondsLost);
		mLost = new JLabel("Total marble lost: " + totalMarbleLost);
		gLost = new JLabel("Total granite lost: " + totalGraniteLost);
		lLost = new JLabel("Total limestone lost: " + totalLimestoneLost);
		
		fiDays = new JLabel("Total days of forest fires: " + fireDays);
		flDays = new JLabel("Total days of flooding: " + floodDays);
		iDays = new JLabel("Total days of internet outages: " + internetDays);
		wDays = new JLabel("Total days of WiFi outages: " + wifiDays);
		
		fiChance = new JLabel("Total chance of forest fires: " + fireChance + "%.");
		flChance = new JLabel("Total chance of flooding: " + floodChance + "%.");
		iChance = new JLabel("Total chance of internet outages: " + internetChance + "%.");
		wChance = new JLabel("Total chance of WiFi outages: " + wifiChance + "%.");
		
//------Font Adjustments---------------------------------------------------------------------------
		dLost.setFont(new Font("Verdana", Font.PLAIN, 9));
		mLost.setFont(new Font("Verdana", Font.PLAIN, 9));
		gLost.setFont(new Font("Verdana", Font.PLAIN, 9));
		lLost.setFont(new Font("Verdana", Font.PLAIN, 9));
		
		fiDays.setFont(new Font("Verdana", Font.PLAIN, 9));
		flDays.setFont(new Font("Verdana", Font.PLAIN, 9));
		iDays.setFont(new Font("Verdana", Font.PLAIN, 9));
		wDays.setFont(new Font("Verdana", Font.PLAIN, 9));
		
		fiChance.setFont(new Font("Verdana", Font.PLAIN, 9));
		flChance.setFont(new Font("Verdana", Font.PLAIN, 9));
		iChance.setFont(new Font("Verdana", Font.PLAIN, 9));
		wChance.setFont(new Font("Verdana", Font.PLAIN, 9));
		
		title.setFont(new Font("Verdana", Font.BOLD, 12));
		
		
		
//------Add the Labels to the Window----------------------------------------------------------------
		disasterStatsWindow.add(title);
		
		disasterStatsWindow.add(fiChance);
		disasterStatsWindow.add(flChance);
		disasterStatsWindow.add(iChance);
		disasterStatsWindow.add(wChance);
		
		disasterStatsWindow.add(divider1);
		
		disasterStatsWindow.add(dLost);
		disasterStatsWindow.add(mLost);
		disasterStatsWindow.add(gLost);
		disasterStatsWindow.add(lLost);
		
		disasterStatsWindow.add(divider2);
		
		disasterStatsWindow.add(fiDays);
		disasterStatsWindow.add(flDays);
		disasterStatsWindow.add(iDays);
		disasterStatsWindow.add(wDays);
		
		disasterStatsWindow.setLayout(new BoxLayout(disasterStatsWindow, BoxLayout.PAGE_AXIS));
		
		return disasterStatsWindow;
	}
	
	public int getDiamondsLost()
		{return totalDiamondsLost;}
	public int getMarbleLost()
		{return totalMarbleLost;}
	public int getGraniteLost()
		{return totalGraniteLost;}
	public int getLimestoneLost()
		{return totalLimestoneLost;}
	
	public void addDiamondsLost(int dLost)
		{totalDiamondsLost = totalDiamondsLost + dLost;}
	public void addMarbleLost(int mLost)
		{totalMarbleLost = totalMarbleLost + mLost;}
	public void addGraniteLost(int gLost)
		{totalGraniteLost = totalGraniteLost + gLost;}
	public void addLimestoneLost(int lLost)
		{totalLimestoneLost = totalLimestoneLost + lLost;}

	public int getFireDays()
		{return fireDays;}
	public int getFloodDays()
		{return floodDays;}
	public int getInternetDays()
		{return internetDays;}
	public int getWifiDays()
		{return wifiDays;}
	
	public void addFireDays(int fiDays)
		{fireDays = fireDays + fiDays;}
	public void addFloodDays(int flDays)
		{floodDays = floodDays + flDays;}
	public void addInternetDays(int iDays)
		{internetDays = internetDays + iDays;}
	public void addWifiDays(int wDays)
		{wifiDays = wifiDays + wDays;}
	
	public int getFireChance()
		{return fireChance;}
	public int getFloodChance()
		{return floodChance;}
	public int getInternetChance()
		{return internetChance;}
	public int getWifiChance()
		{return wifiChance;}
	
	public void setFireChance(int fiChance)
		{fireChance = fiChance;}
	public void setFloodChance(int flChance)
		{floodChance = flChance;}
	public void setInternetChance(int iChance)
		{internetChance = iChance;}
	public void setWifiChance(int wChance)
		{wifiChance = wChance;}
	
}
