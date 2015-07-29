package main.java;

import java.util.ArrayList;

import main.resources.LogReader;
import main.resources.ScorePrinter;

/**
 * @author Claudio Santana
 *
 */
public class Main {
	static LogReader logReader = new LogReader();
	static ScorePrinter scorePrinter = new ScorePrinter();
	static ArrayList<Partida> partidas = new ArrayList<Partida>();
	
	
	public static void main(String [] args){
		partidas = logReader.readLog("matches.log");
		
		scorePrinter.printScore(partidas);
	}

}
