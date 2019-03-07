package Resources;

public class Marble implements Resource{
	private int marble = 0;
	private int marbleWorkers = 0;
	
	public int getWorkers()
		{return marbleWorkers;}
	public void addWorkers()
		{marbleWorkers++;}
	public void setWorkers(int Workers)
		{marbleWorkers = Workers;}
	public void removeWorkers(int Workers)
		{marbleWorkers = marbleWorkers - Workers;}
	
	public int getAmount()
		{return marble;}
	public void addAmount(int addmarble)
		{marble = addmarble;}
	public void setAmount(int setmarble)
		{marble = setmarble;}
	public void removeAmount(int removemarble)
		{marble = marble - removemarble;} 
}
