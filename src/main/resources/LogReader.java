package main.resources;

/**
 * @author Claudio Santana
 *
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import main.java.Partida;

public class LogReader {
	ArrayList<Partida> partidas = new ArrayList<Partida>();
	
	public ArrayList<Partida> readLog(String logName){
		try{
			   FileInputStream fstream = new FileInputStream(logName);
			   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			   String strLine;
			   
			   SimpleDateFormat formatoData= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			   Date dataAtual;
			   
			   Partida partidaAtual = null;

			   String[] parts;

			   while ((strLine = br.readLine()) != null)   {
				   if (strLine.contains(" - ")) {
					   parts = strLine.split(" - ");
					   dataAtual = formatoData.parse(parts[0]);
					   parts = parts[1].split(" ");
					   
					   if(parts.length > 4){
						   if (parts[4].equals("started")){
							   partidaAtual = new Partida(parts[2], dataAtual);
						   } else {
							   if( !parts[0].equals("<WORLD>") ){
								   partidaAtual.addAssassinatoJogador( parts[0], parts[4] );
							   }

							   partidaAtual.addMorteJogador(parts[2]);
						   }
					   } else {
						   partidaAtual.atribuiAwards();
						   this.getPartidas().add(partidaAtual);
					   }
					   
					}
			   }

			   br.close();
			} catch (Exception e) {
			     System.err.println("Error: " + e.getMessage());
			}
		
		return partidas;
	}

	/**
	 * @return the partidas
	 */
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas the partidas to set
	 */
	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}
	
}
