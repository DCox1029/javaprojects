package Game;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JOptionPane;

import Disasters.*;

public class Disasters {
	private ForestFire fire = new ForestFire();
	private WiFiDown wifi = new WiFiDown();
	private Flooding flooding = new Flooding();
	private InternetDown internet = new InternetDown();

	// These numbers are initialized as randomly generated numbers in the disasterListener method.
	// Get the actual disaster chances using the methods at the bottom of this class.
	private int fireChance;
	private int floodChance;
	private int wifiChance;
	private int internetChance;
	
	private DecimalFormat damageFormat = new DecimalFormat("#.##");
	
	public void disasterListener(){
		
		if (VMGame.ifDays() == 0){
			// Only execute if random number generated is less than the disaster's chance 
			// (i.e. A 30 is generated and chance is 5%, then no disaster. If a 2 is generated and chance is 5%, then disaster.)
			Random randomFireDisasterGenerator = new Random();
			fireChance = randomFireDisasterGenerator.nextInt(100);
			if (fire.getChance() >= fireChance)
			{
				Random randomDayGenerator = new Random();
				// Days +1 so that the disaster lasts at least one day
				fire.setDays(randomDayGenerator.nextInt(4) + 1);
				Random randomDamageGenerator = new Random();
				fire.addDamage((randomDamageGenerator.nextDouble()*100));
				VMGame.setFireDays(fire.getDays());
				JOptionPane.showMessageDialog(null, 
						"There have been forests fires reported throughout the southwest." + "\n" + 
						"All production reduced by " + damageFormat.format(fire.getDamage()) + "%. " + "\n" +
						 fire.getDays() + " days remaining.", 
						"Fire!", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (VMGame.ifDays() == 0){
			// Only execute if random number generated is less than the disaster's chance 
			Random randomFloodDisasterGenerator = new Random();
			floodChance = randomFloodDisasterGenerator.nextInt(100);
			if (flooding.getChance() >= floodChance)
			{
				Random randomDayGenerator = new Random();
				// Days +1 so that the disaster lasts at least one day
				flooding.addDays(randomDayGenerator.nextInt(4) + 1);
				Random randomDamageGenerator = new Random();
				flooding.addDamage((randomDamageGenerator.nextDouble()*100));
				VMGame.setFloodDays(flooding.getDays());
				JOptionPane.showMessageDialog(null, 
						"Massive floods have been hitting the southeast." + "\n" + 
						"All production reduced by " + damageFormat.format(flooding.getDamage()) + "%. " + "\n" +
						 flooding.getDays() + " days remaining.", 
						"Floods!", JOptionPane.WARNING_MESSAGE);
			}
		}
	
		if (VMGame.ifDays() == 0){
			// Only execute if random number generated is less than the disaster's chance 
			Random randomWifiDisasterGenerator = new Random();
			wifiChance = randomWifiDisasterGenerator.nextInt(100);
			if (wifi.getChance() >= wifiChance)
			{
				Random randomDayGenerator = new Random();
				// Days +1 so that the disaster lasts at least one day
				wifi.setDays(randomDayGenerator.nextInt(4) + 1);
				Random randomDamageGenerator = new Random();
				wifi.addDamage((randomDamageGenerator.nextDouble()*20));
				wifi.setString();
				VMGame.setWifiDays(wifi.getDays());
				wifi.setMessage("");
				JOptionPane.showMessageDialog(null, 
						"Wireless access has gone down in your " + wifi.getPlantType() + " plants. " + "\n" +
						"Production will be lowered by " + damageFormat.format(wifi.getDamage()) + "%. " + "\n" +
						 wifi.getDays() + " days remaining.", 
						"Wifi is down!", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (VMGame.ifDays() == 0){
			// Only execute if random number generated is less than the disaster's chance 
			Random randomInternetDisasterGenerator = new Random();
			internetChance = randomInternetDisasterGenerator.nextInt(100);
			if (internet.getChance() >= internetChance)
			{
				Random randomDayGenerator = new Random();
				// Days +1 so that the disaster lasts at least one day
				internet.setDays(randomDayGenerator.nextInt(4) + 1);
				Random randomDamageGenerator = new Random();
				internet.addDamage((randomDamageGenerator.nextDouble()*30));
				internet.setString();
				VMGame.setInternetDays(internet.getDays());
				internet.setMessage("");
				JOptionPane.showMessageDialog(null, 
						"The internet has gone down in your " + internet.getPlantType() + " plants. " + "\n" +
						"Production will be lowered by " + damageFormat.format(internet.getDamage()) + "%. " + "\n" +
						 internet.getDays() + " days remaining.", 
						"Internet is down!", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	

	public double getFireDamage()
		{return fire.getDamage();}
	public int getFireDays()
		{return fire.getDays();}
	
	public double getFloodDamage()
		{return flooding.getDamage();}
	public int getFloodDays()
		{return flooding.getDays();}

	public double getInternetDamage()
		{return internet.getDamage();}
	public int getInternetDays()
		{return internet.getDays();}

	public double getWifiDamage()
		{return wifi.getDamage();}
	public int getWifiDays()
		{return wifi.getDays();}
	
	
	public void autoInternet(){
		if (VMGame.store.automationPurchased())
			{internet.setChance(internet.getChance() + 30);}
		}
	
	public void autoWifi(){
		if (VMGame.store.automationPurchased())
			{wifi.setChance(wifi.getChance() + 30);}
		}
	
	public void dynaFire(){
		if (VMGame.store.dynamitePurchased())
			{fire.setChance(fire.getChance() + 8);}
		}
	
	public void extinguisherFire(){
		if (VMGame.store.extinguisherPurchased()){
			// Don't compute a negative chance of fires
			if (fire.getChance() >= 12)
				{fire.setChance(fire.getChance() - 12);}
			else
				{fire.setChance(0);}
		}
	}
	
	public void connectorInternet(){
		if (VMGame.store.connectorPurchased()){
			// Don't compute a negative chance of fires
			if (internet.getChance() >= 22)
				{internet.setChance(internet.getChance() - 22);}
			else
				{internet.setChance(0);}
		}
	}
	
	public void internWifi(){
		if (VMGame.store.internsPurchased()){
			// Don't compute a negative chance of fires
			if (wifi.getChance() >= 26)
				{wifi.setChance(wifi.getChance() - 26);}
			else
				{wifi.setChance(0);}
		}
	}
	
//------Methods for returning disaster chance percentage----------------------------------------------
	public int getFireChance()
		{return fire.getChance();}
	public int getFloodChance()
		{return flooding.getChance();}
	public int getInternetChance()
		{return internet.getChance();}
	public int getWifiChance()
		{return wifi.getChance();}
	
//------Methods for setting disaster chance percentage----------------------------------------------
	public void setFireChance(int fiChance)
		{fire.setChance(fiChance);}
	public void setFloodChance(int flChance)
		{flooding.setChance(flChance);}
	public void setInternetChance(int iChance)
		{internet.setChance(iChance);}
	public void setWifiChance(int wChance)
		{wifiChance = wChance;}
	
//------Methods for adding disaster chance percentage----------------------------------------------
	public void addFireChance(int fiChance)
		{fire.addChance(fiChance);}
	public void addFloodChance(int flChance)
		{flooding.addChance(flChance);}
	public void addInternetChance(int iChance)
		{internet.addChance(iChance);}
	public void addWifiChance(int wChance)
		{wifi.addChance(wChance);}
	
//------Methods for subtracting disaster chance percentage----------------------------------------------
	public void subtractFireChance(int fiChance)
		{fire.subtractChance(fiChance);}
	public void subtractFloodChance(int flChance)
		{flooding.subtractChance(flChance);}
	public void subtractInternetChance(int iChance)
		{internet.subtractChance(iChance);}
	public void subtractWifiChance(int wChance)
		{wifi.subtractChance(wChance);}
	
//------Return whether or not the internet down has affected production of that particular resource------
	public boolean internetDiamondBoolean()
		{return internet.getDiamondBoolean();}
	public boolean internetMarbleBoolean()
		{return internet.getMarbleBoolean();}
	public boolean internetGraniteBoolean()
		{return internet.getGraniteBoolean();}
	public boolean internetLimestoneBoolean()
		{return internet.getLimestoneBoolean();}
	
	public boolean internetAnyTrue()
		{return internet.anyTrue();}
	
//------Reduce the number of days left for the disaster----------------------------------------------
	public void subtractFireDays(int fiDays)
		{fire.subtractDays(fiDays);}
	public void subtractFloodDays(int flDays)
		{flooding.subtractDays(flDays);}
	public void subtractInternetDays(int iDays)
		{internet.subtractDays(iDays);}
	public void subtractWifiDays(int wDays)
		{wifi.subtractDays(wDays);}
	
//------Return whether or not the wifi down has affected production of that particular resource------
	public boolean wifiDiamondBoolean()
		{return wifi.getDiamondBoolean();}
	public boolean wifiMarbleBoolean()
		{return wifi.getMarbleBoolean();}
	public boolean wifiGraniteBoolean()
		{return wifi.getGraniteBoolean();}
	public boolean wifiLimestoneBoolean()
		{return wifi.getLimestoneBoolean();}
	
	public boolean wifiAnyTrue()
		{return internet.anyTrue();}
}
