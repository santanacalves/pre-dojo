package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import main.java.Jogador;
import main.java.ListaJogadores;

public class ListaJogadoresTest {
	ListaJogadores listaJogadores;
	
	@Test
	public void testCriaLista(){
		listaJogadores = new ListaJogadores();
		
		assertNotNull(listaJogadores);
	}

	@Test
	public void testAddJogador(){
		listaJogadores = new ListaJogadores();
		
		listaJogadores.addJogador(new Jogador("Pedro"));
		listaJogadores.addJogador(new Jogador("Nick"));
		listaJogadores.addJogador(new Jogador("Fallen"));
		
		Map<String, Jogador> mapTeste = new HashMap<String, Jogador>();
		
		mapTeste.put("Pedro", listaJogadores.getLista().get("Pedro"));
		mapTeste.put("Nick", listaJogadores.getLista().get("Nick"));
		mapTeste.put("Fallen", listaJogadores.getLista().get("Fallen"));
		
		assertEquals(mapTeste, listaJogadores.getLista());
	}

	@Test
	public void testAddAssassinato(){
		listaJogadores = new ListaJogadores();
		
		listaJogadores.addJogador(new Jogador("Fallen"));
		
		listaJogadores.addAssassinato("Fallen", "AK47");
		
		assertEquals(new Integer(1), listaJogadores.getLista().get("Fallen").getAssassinatos());
		
		listaJogadores.addAssassinato("Fallen", "AK47");
		listaJogadores.addAssassinato("Fallen", "AK47");
		listaJogadores.addAssassinato("Fallen", "AK47");

		assertEquals(new Integer(4), listaJogadores.getLista().get("Fallen").getAssassinatos());
	}

	@Test
	public void testAddMorte(){
		listaJogadores = new ListaJogadores();
		
		listaJogadores.addJogador(new Jogador("Fallen"));
		
		listaJogadores.addMorte("Fallen");
		
		assertEquals(new Integer(1), listaJogadores.getLista().get("Fallen").getMortes());
		
		listaJogadores.addMorte("Fallen");
		listaJogadores.addMorte("Fallen");
		listaJogadores.addMorte("Fallen");

		assertEquals(new Integer(4), listaJogadores.getLista().get("Fallen").getMortes());
	}

	@Test
	public void testAtribuiAwards(){
		listaJogadores = new ListaJogadores();
		
		listaJogadores.addJogador(new Jogador("Fallen"));
		
		listaJogadores.addAssassinato("Fallen", "M16");
		
		listaJogadores.atribuiAwards();
		
		assertEquals(new Integer(1), listaJogadores.getLista().get("Fallen").getAwards());
	}

	@Test
	public void testGetVencedor(){
		listaJogadores = new ListaJogadores();
		
		listaJogadores.addJogador(new Jogador("Fallen"));
		listaJogadores.addJogador(new Jogador("Pedro"));
		listaJogadores.addJogador(new Jogador("Roman"));
		listaJogadores.addJogador(new Jogador("Nick"));
		
		listaJogadores.addAssassinato("Fallen", "AK47");
		listaJogadores.addAssassinato("Roman", "AK47");
		listaJogadores.addAssassinato("Pedro", "AK47");
		listaJogadores.addAssassinato("Nick", "AK47");

		listaJogadores.addAssassinato("Fallen", "M16");
		
		assertEquals("Fallen", listaJogadores.getVencedor().getKey());
	}

	@Test
	public void testGetMaiorKillStreak(){
		listaJogadores = new ListaJogadores();
		
		listaJogadores.addJogador(new Jogador("Fallen"));
		listaJogadores.addJogador(new Jogador("Pedro"));
		listaJogadores.addJogador(new Jogador("Roman"));
		listaJogadores.addJogador(new Jogador("Nick"));
		
		listaJogadores.addAssassinato("Fallen", "AK47");
		listaJogadores.addAssassinato("Fallen", "M16");
		listaJogadores.addAssassinato("Fallen", "M16");
		listaJogadores.addMorte("Fallen");
		
		listaJogadores.addAssassinato("Roman", "AK47");
		listaJogadores.addAssassinato("Pedro", "AK47");
		listaJogadores.addAssassinato("Nick", "AK47");

		listaJogadores.addAssassinato("Fallen", "M16");
		
		assertEquals("Fallen", listaJogadores.getMaiorKillStreak().getKey());
		assertEquals(new Integer(3), listaJogadores.getMaiorKillStreak().getValue().getMaiorKillStreak());
	}
}
