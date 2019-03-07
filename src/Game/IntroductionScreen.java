package Game;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Introduction.*;

public class IntroductionScreen{
	JPanel introScreen = new JPanel();
	
	MainScreen main = new MainScreen();
	HowToPlay how = new HowToPlay();
	Store store = new Store();
	Statistics stats = new Statistics();
	RandomChances chances = new RandomChances();
	Goal goal = new Goal();
	
	public JPanel BuildMainGUI(){
		return main.BuildGUI();
	}
	public JPanel BuildHowGUI(){
		return how.BuildGUI();
	}
	public JPanel BuildStoreGUI(){
		return store.BuildGUI();
	}
	public JPanel BuildStatsGUI(){
		return stats.BuildGUI();
	}
	public JPanel BuildChancesGUI(){
		return chances.BuildGUI();
	}
	public JPanel BuildGoalGUI(){
		return goal.BuildGUI();
	}
	
}
	