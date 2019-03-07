package Inventory;

public class FireExtinguisher implements Item {
	private boolean isPurchased;
	String description = "";
	private int improvedResource;
	
	public void changedValue(int baseResource){
	}
	
	public int returnResource()
		{return improvedResource;}
	
	public void setPurchased(boolean set)
		{isPurchased = set;}
	public boolean getPurchased()
		{return isPurchased;}
}
