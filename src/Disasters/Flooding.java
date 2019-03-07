package Disasters;

public class Flooding implements Disaster{
	private int chance = 1;
	private double damage = 0;
	private int days = 0;
	
	private String message;

	public void addDays(int Days)
		{days = days + Days;}
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
