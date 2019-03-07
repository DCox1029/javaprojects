package Treasures;

public interface Treasure {
	int chance = 0;
	double bonus = 0;
	String message = " ";

	public void setChance(int Chance);
	public int getChance();
	public void addChance(int Chance);
	
	public void setBonus(double Bonus);
	public double getBonus();
	
	public void setMessage(String Message);
	public String getMessage();
}
