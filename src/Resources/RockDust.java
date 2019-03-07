package Resources;

public class RockDust implements Resource {
	
	private int rockdust;
	private int rockdustWorkers;
	
	public int getWorkers()
		{return rockdustWorkers;}
	public void addWorkers()
		{rockdustWorkers++;}
	public void setWorkers(int Workers)
		{rockdustWorkers = Workers;}
	public void removeWorkers(int Workers)
		{rockdustWorkers = rockdustWorkers - Workers;}
	
	public int getAmount()
		{return rockdust;}
	public void addAmount(int addrockdust)
		{rockdust = addrockdust;}
	public void setAmount(int setrockdust)
		{rockdust = setrockdust;}
	public void removeAmount(int removerockdust)
		{rockdust = rockdust - removerockdust;} 
}
