package Game;
import Treasures.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class Treasures {
	private DiamondVein diamondVein = new DiamondVein();
	private Fossils fossils = new Fossils();
	private GoldVein goldVein = new GoldVein();
	
	private int diamondChance;
	private int fossilChance;
	private int goldChance;
	
	public void treasureListener(){
		
//------Diamond Vein------------------------------------------------------------------------
		Random randomDiamondGenerator = new Random();
		diamondChance = randomDiamondGenerator.nextInt(100);
		if (diamondVein.getChance() >= diamondChance)
		{		
		Random randomBonusGenerator = new Random();
		diamondVein.setBonus(randomBonusGenerator.nextInt(5));
		JOptionPane.showMessageDialog(null, 
				"While digging, your workers struck a diamond vein" + "\n" 
				+ "Your workers managed to extract " + diamondVein.getBonus()  + " diamonds from the vein.", 
				"Diamond Vein Found!", JOptionPane.WARNING_MESSAGE);}
		VMGame.setDiamondBoolean(true);
		
//------Fossils------------------------------------------------------------------------------
		Random randomFossilGenerator = new Random();
		fossilChance = randomFossilGenerator.nextInt(100);
		if (fossils.getChance() >= fossilChance)
		{		
		Random randomBonusGenerator = new Random();
		fossils.setBonus(randomBonusGenerator.nextInt(500));
		JOptionPane.showMessageDialog(null, 
				"While digging, your workers found valuable fossils worth $" + fossils.getBonus(), 
				"Fossils Found!", JOptionPane.WARNING_MESSAGE);}
		VMGame.setFossilBoolean(true);
	
//------Diamond Vein------------------------------------------------------------------------
		Random randomGoldGenerator = new Random();
		goldChance = randomGoldGenerator.nextInt(100);
		if (goldVein.getChance() >= goldChance)
		{		
		Random randomBonusGenerator = new Random();
		goldVein.setBonus(randomBonusGenerator.nextInt(2500));
		JOptionPane.showMessageDialog(null, 
				"While digging, your workers struck a gold vein" + "\n" 
				+ "Your workers managed to extract $" + goldVein.getBonus()  + " worth of gold from the vein.", 
				"Gold Vein Found!", JOptionPane.WARNING_MESSAGE);}
		VMGame.setGoldBoolean(true);
	}
	
	public void surveyorsAdd(){
		if (VMGame.store.surveyorsPurchased()){
			diamondVein.addChance(3);
			goldVein.addChance(5);
		}
	}
	public double getFossilAmount()
		{return fossils.getBonus();}
	public int getDiamondAmount()
		{return diamondVein.getBonus();}
	public double getGoldAmount()
		{return goldVein.getBonus();}
	
	public int getFossilChance()
		{return fossils.getChance();}
	public int getDiamondChance()
		{return diamondVein.getChance();}
	public int getGoldChance()
		{return goldVein.getChance();}
	
	
}
