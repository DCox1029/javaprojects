package Disasters;

public class InternetDown implements Disaster{
	private int chance = 3;
	private double damage;
	private int days;
	
	private double diamondCoinFlip;
	private double marbleCoinFlip;
	private double graniteCoinFlip;
	private double limestoneCoinFlip;
	
	private String plantType = "";
	
	private boolean diamonds;
	private boolean marble;
	private boolean granite;
	private boolean limestone;
	
	private String message;
	
	public void setString(){
		diamondCoinFlip = Math.random();
		marbleCoinFlip = Math.random();
		graniteCoinFlip = Math.random();
		limestoneCoinFlip = Math.random();
		
		if (diamondCoinFlip > 0.5){
			plantType = plantType + "Diamond ";
			diamonds = true;
			}
		
		if (marbleCoinFlip > 0.5){
			plantType = plantType + "Marble ";
			marble = true;
			}
		
		if (graniteCoinFlip > 0.5){
			plantType = plantType + "Granite ";
			granite = true;
			}
		
		if (limestoneCoinFlip > 0.5){
			plantType = plantType + "Limestone ";
			limestone = true;
			}
	}

	public String getPlantType()
		{return plantType;}
	
	public void setDays(int Days)
		{days = Days;}
	public void subtractDays(int Days)
		{days = days - Days;}
	public int getDays()
		{return days;}

	public void setChance(int Chance)
		{chance = Chance;}
	public void addChance(int Chance)
		{chance = chance + Chance;}
	public void subtractChance(int Chance)
		{chance = chance - Chance;}
	public int getChance()
		{return chance;}

	public void addDamage(double Damage)
		{damage = damage + Damage;}
	public void setDamage(double Damage)
		{damage = Damage;}
	public double getDamage()
		{return damage;}

	public void setMessage(String Message)
		{message = Message;}
	public String getMessage()
		{return message;}
	
	public boolean getDiamondBoolean()
		{return diamonds;}
	public boolean getMarbleBoolean()
		{return marble;}
	public boolean getGraniteBoolean()
		{return granite;}
	public boolean getLimestoneBoolean()
		{return limestone;}
	
	public boolean anyTrue(){
		if (diamonds || marble || granite || limestone)
			return true;
		else
			return false;
	}
}
