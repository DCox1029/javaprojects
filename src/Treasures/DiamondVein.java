package Treasures;

public class DiamondVein{
	private int chance = 1;
	private int bonus;
	private double worth;
	
	private String message;

	public void setChance(int Chance)
		{chance = Chance;}
	public int getChance()
		{return chance;}
	public void addChance(int Chance)
		{chance = chance + Chance;}
		
	public void setBonus(int Bonus)
		{bonus = Bonus;}
	public int getBonus()
		{return bonus;}
	
	public void setMessage(String Message)
		{message = Message;}
	public String getMessage()
		{return message;}
}	
