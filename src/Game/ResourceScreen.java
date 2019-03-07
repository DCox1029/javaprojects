package Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Resources.Diamond;
import Resources.Granite;
import Resources.Limestone;
import Resources.Marble;
import Resources.RockDust;


public class ResourceScreen extends JPanel {
	
	String header[] = {"Diamonds", "Marble: ", "Granite: ", "Limestone: ", "Rock Dust: "};
	String data[][];
	DefaultTableModel model = new DefaultTableModel(data, header){
		public boolean isCellEditable(int row, int column){
			return false;
		}
	};
	
	String mheader[] = {"Money: "};
	String mdata[][];
	DefaultTableModel mmodel = new DefaultTableModel(mdata, mheader){
		public boolean isCellEditable(int row, int column){
			return false;
		}
	};
	
	String qheader[] = {"<Html>Diamond Workers: </Html>", "<Html>Marble Workers: </Html>", "<Html>Granite Workers: </Html>", "<Html>Limestone Workers: </html>"};
	String qdata[][];
	DefaultTableModel qmodel = new DefaultTableModel(qdata, qheader){	
		public boolean isCellEditable(int row, int column){
			return false;
		}
	};
	
	JPanel tPanel;

//------Resource Quantities-----------------------------------------------------------------------
	JScrollPane mPane;
	
	DecimalFormat moneyFormat = new DecimalFormat("###,###,###,###.##");
	private double money;
	private Diamond diamonds = new Diamond();
	private Marble marble = new Marble();
	private Granite granite = new Granite();
	private Limestone limestone = new Limestone();
	private RockDust rockdust = new RockDust();
	
	private int totalWorkers = 0;
	
	public static void main(String args[]){
		new ResourceScreen();
	}
	
	public ResourceScreen(){
		BuildImage();
	}
	
	public JPanel BuildSellImage(){
//------Create Table for Money--------------------------------------------------------------------	
	mmodel.setRowCount(0);
	mmodel.insertRow(mmodel.getRowCount(), new Object[]{"$" + moneyFormat.format(money)});
	JTable mtable = new JTable(mmodel);
		
//------Create Table for Resources----------------------------------------------------------------		
	model.setRowCount(0);
	model.insertRow(model.getRowCount(), new Integer[]{diamonds.getAmount(), marble.getAmount(), granite.getAmount(), limestone.getAmount(), rockdust.getAmount()});
	JTable table = new JTable(model);
	
//------These methods align the text in the tables to the right-----------------------------------------
	for (int i = 0; i < mtable.getModel().getRowCount(); i++) {
		   for (int j = 0; j < mtable.getModel().getColumnCount(); j++) {
		      DefaultTableCellRenderer renderer =
		         (DefaultTableCellRenderer)mtable.getCellRenderer(i, j);
		      renderer.setHorizontalAlignment(JTextField.RIGHT);
		 }
	}
	for (int i = 0; i < table.getModel().getRowCount(); i++) {
		   for (int j = 0; j < table.getModel().getColumnCount(); j++) {
		      DefaultTableCellRenderer renderer =
		         (DefaultTableCellRenderer)table.getCellRenderer(i, j);
		      renderer.setHorizontalAlignment(JTextField.RIGHT);
		 }
	}
	
	JScrollPane rPane = new JScrollPane(table);
	mPane = new JScrollPane(mtable);
	rPane.setPreferredSize(new Dimension(400,40));
	mPane.setPreferredSize(new Dimension(100,40));
		
	tPanel = new JPanel();
    tPanel.setLayout(new BorderLayout());
    tPanel.add(rPane, BorderLayout.CENTER);
    tPanel.add(mPane, BorderLayout.NORTH);
    return tPanel;
	}
	
	public JPanel BuildBuyImage(){
	//------Create Table for Money--------------------------------------------------------------------	
	mmodel.setRowCount(0);
	mmodel.insertRow(mmodel.getRowCount(), new Object[]{"$" + moneyFormat.format(money)});
	JTable mtable = new JTable(mmodel);
		
//------Create Table for Workers-----------------------------------------------------------------	
	qmodel.setRowCount(0);
	qmodel.insertRow(qmodel.getRowCount(), new Integer[]{diamonds.getWorkers(), marble.getWorkers(), granite.getWorkers(), limestone.getWorkers()});
	JTable qtable = new JTable(qmodel);
	
//------These methods align the text in the tables to the right-----------------------------------------
	for (int i = 0; i < mtable.getModel().getRowCount(); i++) {
		   for (int j = 0; j < mtable.getModel().getColumnCount(); j++) {
		      DefaultTableCellRenderer renderer =
		         (DefaultTableCellRenderer)mtable.getCellRenderer(i, j);
		      renderer.setHorizontalAlignment(JTextField.RIGHT);
		 }
	}
	for (int i = 0; i < qtable.getModel().getRowCount(); i++) {
		   for (int j = 0; j < qtable.getModel().getColumnCount(); j++) {
		      DefaultTableCellRenderer renderer =
		         (DefaultTableCellRenderer)qtable.getCellRenderer(i, j);
		      renderer.setHorizontalAlignment(JTextField.RIGHT);
		 }
	}
	
	mPane = new JScrollPane(mtable);
	JScrollPane qPane = new JScrollPane(qtable);
 	mPane.setPreferredSize(new Dimension(100,40));
 	qPane.setPreferredSize(new Dimension(450,40));
	
	tPanel = new JPanel();
    tPanel.setLayout(new BorderLayout());
    tPanel.add(qPane, BorderLayout.CENTER);
    tPanel.add(mPane, BorderLayout.NORTH);
    return tPanel;
	}
		
	
	public JPanel BuildImage(){

//------Create Table for Resources----------------------------------------------------------------		
	model.setRowCount(0);
	model.insertRow(model.getRowCount(), new Integer[]{diamonds.getAmount(), marble.getAmount(), granite.getAmount(), limestone.getAmount(), rockdust.getAmount()});
	JTable table = new JTable(model);

//------Create Table for Money--------------------------------------------------------------------	
	mmodel.setRowCount(0);
	mmodel.insertRow(mmodel.getRowCount(), new Object[]{"$" + moneyFormat.format(money)});
	JTable mtable = new JTable(mmodel);
	
//------Create Table for Workers-----------------------------------------------------------------	
	qmodel.setRowCount(0);
	qmodel.insertRow(qmodel.getRowCount(), new Integer[]{diamonds.getWorkers(), marble.getWorkers(), granite.getWorkers(), limestone.getWorkers()});
	JTable qtable = new JTable(qmodel);

//------These methods align the text in the tables to the right-----------------------------------------
	for (int i = 0; i < mtable.getModel().getRowCount(); i++) {
		   for (int j = 0; j < mtable.getModel().getColumnCount(); j++) {
			   	DefaultTableCellRenderer renderer =
			    		 (DefaultTableCellRenderer)mtable.getCellRenderer(i, j);
		    renderer.setHorizontalAlignment(JTextField.RIGHT);
		 }
	}
	for (int i = 0; i < table.getModel().getRowCount(); i++) {
			  for (int j = 0; j < table.getModel().getColumnCount(); j++) {
			     DefaultTableCellRenderer renderer =
			       (DefaultTableCellRenderer)table.getCellRenderer(i, j);
			     renderer.setHorizontalAlignment(JTextField.RIGHT);
		 }
	}
	for (int i = 0; i < qtable.getModel().getRowCount(); i++) {
		  for (int j = 0; j < qtable.getModel().getColumnCount(); j++) {
		     DefaultTableCellRenderer renderer =
		       (DefaultTableCellRenderer)qtable.getCellRenderer(i, j);
		     renderer.setHorizontalAlignment(JTextField.RIGHT);
	 }
}
	
	
//------Add the tables to their own panes and adjust their dimensions-----------------------------
    JScrollPane rPane = new JScrollPane(table);
    mPane = new JScrollPane(mtable);
    JScrollPane qPane = new JScrollPane(qtable);
    rPane.setPreferredSize(new Dimension(400,40));
    mPane.setPreferredSize(new Dimension(100,40));
    qPane.setPreferredSize(new Dimension(450,40));
    
    tPanel = new JPanel();
    tPanel.setLayout(new BorderLayout());
    tPanel.add(rPane, BorderLayout.CENTER);
    tPanel.add(mPane, BorderLayout.NORTH);
    tPanel.add(qPane, BorderLayout.SOUTH);
    return tPanel;
	}
	
	public void reset()
	{model.setRowCount(0);}
	
	public void moneyUpdate(){
		mmodel.setRowCount(0);
		mmodel.insertRow(mmodel.getRowCount(), new Object[]{"$" + moneyFormat.format(money)});
	}
	
	public void resourceUpdate(){
		model.setRowCount(0);
		model.insertRow(model.getRowCount(), new Integer[]{diamonds.getAmount(), marble.getAmount(), granite.getAmount(), limestone.getAmount(), rockdust.getAmount()});
	}
	
	public void workersUpdate(){
		qmodel.setRowCount(0);
		qmodel.insertRow(qmodel.getRowCount(), new Integer[]{diamonds.getWorkers(), marble.getWorkers(), granite.getWorkers(), limestone.getWorkers()});
	}
	
//------Set Resources-----------------------------------------------------------------------------
	public void setMoney(Double Money){
		money = Money;
		moneyUpdate();
	}
	
	public void setDiamonds(int Diamonds){
		diamonds.setAmount(Diamonds);
		resourceUpdate();
	}
	
	public void setMarble(int Marble){
		marble.setAmount(Marble);
		resourceUpdate();
	}
	
	public void setGranite(int Granite){
		granite.setAmount(Granite);
		resourceUpdate();
	}
	
	public void setLimestone(int Limestone){
		limestone.setAmount(Limestone);
		resourceUpdate();
	}
	
	public void setRockdust(int Rockdust){
		rockdust.setAmount(Rockdust);
		resourceUpdate();
	}
	
	
//------Add Workers-------------------------------------------------------------------------------
	public void addDiamondWorkers(){
		totalWorkers++;
		diamonds.addWorkers();
		workersUpdate();
	}
	
	public void addMarbleWorkers(){
		totalWorkers++;
		marble.addWorkers();
		workersUpdate();
	}
	
	public void addGraniteWorkers(){
		totalWorkers++;
		granite.addWorkers();
		workersUpdate();
	}
	
	public void addLimestoneWorkers(){
		totalWorkers++;
		limestone.addWorkers();
		workersUpdate();
	}
	
//------Get Workers-------------------------------------------------------------------------------
	public int getDiamondWorkers()
		{return diamonds.getWorkers();}
	
	public int getMarbleWorkers()
		{return marble.getWorkers();}
	
	public int getGraniteWorkers()
		{return granite.getWorkers();}
	
	public int getLimestoneWorkers()
		{return limestone.getWorkers();}
	
	public int getTotalWorkers()
		{return totalWorkers;}
	
//------Set Workers-------------------------------------------------------------------------------
	public void setTotalWorkers(int Workers){
		totalWorkers = Workers;
		workersUpdate();	
	}
	
	public void setDiamondWorkers(int Workers){
		diamonds.setWorkers(Workers);
		workersUpdate();	
	}
	
	public void setMarbleWorkers(int Workers){
		marble.setWorkers(Workers);
		workersUpdate();	
	}
	
	public void setGraniteWorkers(int Workers){
		granite.setWorkers(Workers);
		workersUpdate();	
	}
	
	public void setLimestoneWorkers(int Workers){
		limestone.setWorkers(Workers);
		workersUpdate();	
	}
	
	public void setRockdustWorkers(int Workers){
		rockdust.setWorkers(Workers);
		workersUpdate();	
	}
	
//------Get Resources-----------------------------------------------------------------------------
	public int getDiamond()
	{return diamonds.getAmount();}
	
	public int getMarble()
	{return marble.getAmount();}
	
	public int getGranite()
	{return granite.getAmount();}
	
	public int getLimestone()
	{return limestone.getAmount();}
	
	public int getRockdust()
	{return rockdust.getAmount();}
	
	public double getMoney()
	{return money;}
	
//------Add Resources-----------------------------------------------------------------------------	
	public void addMoney(Double Money){
		money = money + Money;
		moneyUpdate();
	}
	
	public void addDiamonds(int Diamonds){
		diamonds.setAmount(diamonds.getAmount() + Diamonds);
		resourceUpdate();
	}
	
	public void addMarble(int Marble){
		marble.setAmount(marble.getAmount() + Marble);
		resourceUpdate();
	}
	
	public void addGranite(int Granite){
		granite.setAmount(granite.getAmount() + Granite);
		resourceUpdate();
	}
	
	public void addLimestone(int Limestone){
		limestone.setAmount(limestone.getAmount() + Limestone);
		resourceUpdate();
	}
	
	public void addRockdust(int Rockdust){
		rockdust.setAmount(rockdust.getAmount() + Rockdust);
		resourceUpdate();
	}
	
//------Remove Resources--------------------------------------------------------------------------
	public void removeMoney(int Money){
		money = money - Money;
		moneyUpdate();
	}
	
	public void removeDiamonds(int Diamonds){
		diamonds.setAmount(diamonds.getAmount() - Diamonds);
		resourceUpdate();
	}
	
	public void removeMarble(int Marble){
		marble.setAmount(marble.getAmount() - Marble);
		resourceUpdate();
	}
	
	public void removeGranite(int Granite){
		granite.setAmount(granite.getAmount() - Granite);
		resourceUpdate();
	}
	
	public void removeLimestone(int Limestone){
		limestone.setAmount(limestone.getAmount() - Limestone);
		resourceUpdate();
	}
	
	public void removeRockdust(int Rockdust){
		rockdust.setAmount(rockdust.getAmount() - Rockdust);
		resourceUpdate();
	}
}
