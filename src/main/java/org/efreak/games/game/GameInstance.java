package org.efreak.games.game;

import java.util.ArrayList;
import java.util.List;

import org.efreak.games.GamePlayer;

public abstract class GameInstance {

	private final Game game;
	private List<GamePlayer> players;
	
	public GameInstance(Game game) {
		this.game = game;
		players = new ArrayList<GamePlayer>();
	}
	
	public abstract boolean start();
	public abstract void stop();
	
	public Game getGame() {
		return game;
	}
	
	public boolean join(GamePlayer player) {
		return true;
	}
}
