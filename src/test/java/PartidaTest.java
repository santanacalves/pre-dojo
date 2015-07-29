package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import main.java.Partida;

public class PartidaTest {
	Partida partidaTeste = new Partida();
	
	@Test
	public void testCriaPartida() {
	    partidaTeste = new Partida("1", new Date());
	    
	    assertNotNull(partidaTeste);
	    assertEquals("1", partidaTeste.getIdPartida());
	}

	@Test
	public void testAddAssasinato() {
	    partidaTeste = new Partida("1", new Date());
	    
		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		
		assertEquals(new Integer(1), partidaTeste.getListaJogadores().getLista().get("Fallen").getAssassinatos());

		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		
		assertEquals(new Integer(3), partidaTeste.getListaJogadores().getLista().get("Fallen").getAssassinatos());		
	}
	
	@Test
	public void testAddMorte(){
	    partidaTeste = new Partida("1", new Date());
	    
		partidaTeste.addMorteJogador("Fallen");
		
		assertEquals(new Integer(1), partidaTeste.getListaJogadores().getLista().get("Fallen").getMortes());

		partidaTeste.addMorteJogador("Fallen");
		partidaTeste.addMorteJogador("Fallen");
		
		assertEquals(new Integer(3), partidaTeste.getListaJogadores().getLista().get("Fallen").getMortes());		
	}

	@Test
	public void testAtribuiAwards(){
	    partidaTeste = new Partida("1", new Date());
	    
		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		
		partidaTeste.atribuiAwards();
		
		assertEquals(new Integer(1), partidaTeste.getListaJogadores().getLista().get("Fallen").getAwards());
	}
	
	@Test
	public void testGetVencedor(){
	    partidaTeste = new Partida("1", new Date());
	    
		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		
		assertEquals("Fallen", partidaTeste.getVencedor().getKey());
	}
	
	@Test
	public void testGetMaiorKillStreak(){
		partidaTeste = new Partida("1", new Date());
	    
		partidaTeste.addAssassinatoJogador("Fallen", "AK47");
		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		partidaTeste.addMorteJogador("Fallen");
		
		partidaTeste.addAssassinatoJogador("Roman", "AK47");
		partidaTeste.addAssassinatoJogador("Pedro", "AK47");
		partidaTeste.addAssassinatoJogador("Nick", "AK47");

		partidaTeste.addAssassinatoJogador("Fallen", "M16");
		
		assertEquals("Fallen", partidaTeste.getMaiorKillStreak().getKey());
		assertEquals(new Integer(3), partidaTeste.getMaiorKillStreak().getValue().getMaiorKillStreak());
	}
}
