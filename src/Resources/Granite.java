package Resources;

public class Granite implements Resource{
	private int granite = 0;
	private int graniteWorkers = 0;
	
	public int getWorkers()
		{return graniteWorkers;}
	public void addWorkers()
		{graniteWorkers++;}
	public void setWorkers(int Workers)
		{graniteWorkers = Workers;}
	public void removeWorkers(int Workers)
		{graniteWorkers = graniteWorkers - Workers;}
	
	public int getAmount()
		{return granite;}
	public void addAmount(int addgranite)
		{granite = addgranite;}
	public void setAmount(int setgranite)
		{granite = setgranite;}
	public void removeAmount(int removegranite)
		{granite = granite - removegranite;} 
}
