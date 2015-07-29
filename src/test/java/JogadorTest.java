package test.java;

/**
 * @author Claudio Santana
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Jogador;

public class JogadorTest {
	Jogador jogadorTeste;
	
	@Test
	public void testCriaJogador() {
	    jogadorTeste = new Jogador("Jogador Teste");
	    
	    assertNotNull(jogadorTeste);
	    assertEquals("Jogador Teste", jogadorTeste.getNomeJogador());
	}

	@Test
	public void testAddAssassinato() {
		jogadorTeste = new Jogador("Jogador Teste");
		
	    jogadorTeste.addAssassinato("AK47");
	    jogadorTeste.addAssassinato("M16");
	    jogadorTeste.addAssassinato("AK47");
	    jogadorTeste.addAssassinato("M16");
	    jogadorTeste.addAssassinato("M16");
	    
	    assertEquals( new Integer(5), jogadorTeste.getAssassinatos() );
	}

	@Test
	public void testArmaPreferida() {
		jogadorTeste = new Jogador("Jogador Teste");
		
	    jogadorTeste.addAssassinato("AK47");
	    jogadorTeste.addAssassinato("M16");
	    jogadorTeste.addAssassinato("AK47");
	    jogadorTeste.addAssassinato("M16");
	    jogadorTeste.addAssassinato("M16");
	    
	    assertEquals("M16", jogadorTeste.getArmaPreferida());
	    
	    jogadorTeste.addAssassinato("AK47");
	    jogadorTeste.addAssassinato("AK47");
	    
	    assertEquals("AK47", jogadorTeste.getArmaPreferida());

	}

	@Test
	public void testAddMorte() {
		jogadorTeste = new Jogador("Jogador Teste");

		jogadorTeste.addMorte();
		
	    assertEquals(new Integer(1), jogadorTeste.getMortes());

		jogadorTeste.addMorte();
		jogadorTeste.addMorte();
		jogadorTeste.addMorte();

	    assertEquals(new Integer(4), jogadorTeste.getMortes());
	}


	@Test
	public void testAddAwards() {
		jogadorTeste = new Jogador("Jogador Teste");

		jogadorTeste.addAward();
		
		assertEquals(new Integer(1), jogadorTeste.getAwards());

	}
	@Test
	public void testKillStreakAtual() {
		jogadorTeste = new Jogador("Jogador Teste");

		jogadorTeste.addAssassinato("M16");
		
		assertEquals(new Integer(1), jogadorTeste.getKillStreakAtual());
		
		jogadorTeste.addMorte();

		assertEquals(new Integer(0), jogadorTeste.getKillStreakAtual());

		jogadorTeste.addAssassinato("M16");
		jogadorTeste.addAssassinato("M16");
		jogadorTeste.addAssassinato("AK47");
		jogadorTeste.addAssassinato("AK47");
		
		assertEquals(new Integer(4), jogadorTeste.getKillStreakAtual());

		jogadorTeste.addMorte();

		assertEquals(new Integer(0), jogadorTeste.getKillStreakAtual());

	}

	@Test
	public void testMaiorKillStreak() {
		jogadorTeste = new Jogador("Jogador Teste");

		jogadorTeste.addAssassinato("M16");
		
		jogadorTeste.addMorte();

		jogadorTeste.addAssassinato("M16");
		jogadorTeste.addAssassinato("M16");
		jogadorTeste.addAssassinato("AK47");
		jogadorTeste.addAssassinato("AK47");
		
		jogadorTeste.addMorte();

		jogadorTeste.addAssassinato("AK47");
		jogadorTeste.addAssassinato("AK47");

		assertEquals(new Integer(2), jogadorTeste.getKillStreakAtual());
		assertEquals(new Integer(4), jogadorTeste.getMaiorKillStreak());

	}

}
