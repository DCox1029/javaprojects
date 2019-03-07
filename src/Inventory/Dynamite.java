package Inventory;

public class Dynamite implements Item{
	private boolean isPurchased;
	String description = "";
	private int improvedResource;
	
	public void changedValue(int baseResource){
		int percentage = 2;
		improvedResource = baseResource*percentage;	
	}
	
	public int returnResource()
		{return improvedResource;}
	
	public void setPurchased(boolean set)
		{isPurchased = set;}
	public boolean getPurchased()
		{return isPurchased;}
}
