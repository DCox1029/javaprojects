package Resources;

public interface Resource {
	
	public int getWorkers();
	public void addWorkers();
	public void setWorkers(int Workers);
	public void removeWorkers(int Workers);
	
	public int getAmount();
	public void addAmount(int resource);
	public void setAmount(int resource);
	public void removeAmount(int resource);
}
