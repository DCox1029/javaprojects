package Treasures;

public class GoldVein {
	private int chance = 3;
	private double bonus;
	private String message = " ";

	public void setChance(int Chance)
		{chance = Chance;}
	public int getChance()
		{return chance;}
	public void addChance(int Chance)
		{chance = chance + Chance;}
		
	public void setBonus(double Bonus)
		{bonus = Bonus;}
	public double getBonus()
		{return bonus;}
	
	public void setMessage(String Message)
		{message = Message;}
	public String getMessage()
		{return message;}
}
