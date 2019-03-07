package Inventory;

public class NetworkInterns implements Item {
	private boolean isPurchased;
	String description = "";
	private int improvedResource;
	
	public void changedValue(int baseResource){
		double percentage = 1.50;
		improvedResource = (int)(baseResource*percentage);	
	}
	
	public int returnResource()
		{return improvedResource;}
	
	public void setPurchased(boolean set)
		{isPurchased = set;}
	public boolean getPurchased()
		{return isPurchased;}

}
