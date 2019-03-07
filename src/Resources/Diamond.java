package Resources;

public class Diamond implements Resource{
	private int diamond = 0;
	private int diamondWorkers = 0;
	
	public int getWorkers()
		{return diamondWorkers;}
	public void addWorkers()
		{diamondWorkers++;}
	public void setWorkers(int Workers)
		{diamondWorkers = Workers;}
	public void removeWorkers(int workers)
		{diamondWorkers = diamondWorkers - workers;}
	
	public int getAmount()
		{return diamond;}
	public void addAmount(int adddiamond)
		{diamond = adddiamond;}
	public void setAmount(int setdiamond)
		{diamond = setdiamond;}
	public void removeAmount(int removediamond)
		{diamond = diamond - removediamond;} 
}
