package Resources;

public class Limestone implements Resource {
	private int limestone = 0;
	private int limestoneWorkers = 0;
	
	public int getWorkers()
		{return limestoneWorkers;}
	public void addWorkers()
		{limestoneWorkers++;}
	public void setWorkers(int Workers)
		{limestoneWorkers = Workers;}
	public void removeWorkers(int Workers)
		{limestoneWorkers = limestoneWorkers - Workers;}
	
	public int getAmount()
		{return limestone;}
	public void addAmount(int addlimestone)
		{limestone = addlimestone;}
	public void setAmount(int setlimestone)
		{limestone = setlimestone;}
	public void removeAmount(int removelimestone)
		{limestone = limestone - removelimestone;} 
}
