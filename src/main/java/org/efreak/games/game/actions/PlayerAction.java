package org.efreak.games.game.actions;

import org.efreak.games.GamePlayer;

public class PlayerAction implements GameAction {

	private GamePlayer player;
	
	public PlayerAction(GamePlayer player) {
		this.player = player;
	}
	
	public GamePlayer getPlayer() {
		return player;
	}
	
}
