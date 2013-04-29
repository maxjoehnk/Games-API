package org.efreak.games;

import java.util.Collection;
import java.util.HashMap;

import org.efreak.games.game.Game;
import org.efreak.games.game.GameInstance;

public class GameManager {

	private static HashMap<String, Game> games;
	
	static {
		games = new HashMap<String, Game>();
	}
	
	public static void loadGame(Game game) {
		game.load();
		games.put(game.getName(), game);
	}
	
	public static void startGame(String id, String game) {
		GameInstance instance = games.get(game).createInstance();
		games.get(game).startGame(id, instance);
	}
	
	public static HashMap<String, Game> getGames() {
		return games;
	}
	
	public static Collection<Game> getGameList() {
		return games.values();
	}
}
 