/**
 * 
 */
package main.resources;

import java.util.ArrayList;
import java.util.Map.Entry;

import main.java.Jogador;
import main.java.Partida;

/**
 * @author Claudio Santana
 *
 */
public class ScorePrinter {
	public void printScore( ArrayList<Partida> partidas ) {
		for(Partida partida : partidas) {
            System.out.println("Partida " + partida.getIdPartida() + ":");
            
            Jogador jogadorAtual;
            
            for (Entry<String, Jogador> itemLista : partida.getListaJogadores().getLista().entrySet()) {
                jogadorAtual = itemLista.getValue();

                System.out.println("- Jogador: " + itemLista.getKey());
                System.out.println("- Assassinatos: " + jogadorAtual.getAssassinatos());
                System.out.println("- Mortes: " + jogadorAtual.getMortes());
                System.out.println("- Awards: " + jogadorAtual.getAwards());

                System.out.println("");
            }            
            System.out.println("Vencedor: " + partida.getVencedor().getKey() + " | Arma preferida: " + partida.getVencedor().getValue().getArmaPreferida());
            System.out.println("Maior kill streak: " + partida.getMaiorKillStreak().getValue().getMaiorKillStreak() + " | Feito por: " + partida.getMaiorKillStreak().getValue().getNomeJogador());
            
            System.out.println("");
            System.out.println("");
            
        }
		
	}


}
