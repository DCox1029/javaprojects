package Disasters;

public interface Disaster {
	int chance = 0;
	double damage = 0;
	String message = " ";

	public void setChance(int Chance);
	public int getChance();
	
	public void addDamage(double Damage);
	public double getDamage();
	
	public void setMessage(String Message);
	public String getMessage();
}
