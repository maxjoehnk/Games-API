package org.efreak.games;

import org.bukkit.entity.Player;
import org.efreak.games.game.Game;

public class GamePlayer {

	private boolean inGame = false;
	private Game game = null;
	private final Player player;
	
	public GamePlayer(Player player) {
		this.player = player;
	}
	
	public boolean isInGame() {
		return inGame;
	}
	
	public Game getGame() {
		return game;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
