package main.java;

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
import java.util.Map;
import java.util.Map.Entry;

public class LogReader {
	ArrayList<Partida> partidas = new ArrayList<Partida>();
	
	public static void main(String [] args){
		LogReader logReader = new LogReader();
		logReader.readLog();
		
		logReader.printScore();
	}

	private void printScore() {
		for(Partida partida : partidas) {
            System.out.println("Partida " + partida.getIdPartida() + ":");
            
            Jogador jogadorAtual;
            
            for (Entry<String, Jogador> itemLista : partida.getListaJogadores().getLista().entrySet()) {
                jogadorAtual = itemLista.getValue();

                System.out.println("- Jogador: " + itemLista.getKey());
                System.out.println("- Assassinatos: " + jogadorAtual.getAssassinatos());
                System.out.println("- Mortes: " + jogadorAtual.getMortes());

                System.out.println("");
            }            
            System.out.println("Vencedor: " + partida.getVencedor().getKey() + " | Arma preferida: " + partida.getVencedor().getValue().getArmaPreferida());
            System.out.println("Maior kill streak: " + partida.getMaiorKillStreak().getValue().getMaiorKillStreak() + " | Feito por: " + partida.getMaiorKillStreak().getValue().getNomeJogador());
            
            System.out.println("");
            System.out.println("");
            
        }
		
	}

	public void readLog(){
		try{
			   FileInputStream fstream = new FileInputStream("matches.log");
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
								   partidaAtual.addAssasinatoJogador( parts[0], parts[4] );
							   }

							   partidaAtual.addMorteJogador(parts[2]);
						   }
					   } else {
						   this.getPartidas().add(partidaAtual);
					   }
					   
					} else {
						
					}
//			     System.out.println (strLine);
			   }

			   br.close();
			} catch (Exception e) {
			     System.err.println("Error: " + e.getMessage());
			}
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
