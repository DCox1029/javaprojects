package Disasters;

public class ForestFire implements Disaster{
	private int chance = 1;
	private double damage;
	private int days;

	private String message;

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
	public double getDamage()
		{return damage;}

	public void setMessage(String Message)
		{message = Message;}
	public String getMessage()
		{return message;}
	
}
