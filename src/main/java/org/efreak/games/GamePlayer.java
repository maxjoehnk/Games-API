package org.efreak.games;

import org.bukkit.entity.Player;
import org.efreak.games.game.Game;
import org.efreak.games.game.GameInstance;

public class GamePlayer {

	private boolean inGame = false;
	private GameInstance game = null;
	private final Player player;
	
	public GamePlayer(Player player) {
		this.player = player;
	}
	
	public boolean isInGame() {
		return inGame;
	}
	
	public GameInstance getGame() {
		return game;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
