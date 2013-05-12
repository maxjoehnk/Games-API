package org.efreak.games.game.actions;

import org.efreak.games.GamePlayer;

public class PlayerJoinAction implements PlayerAction {
	
	private GamePlayer player;
	
	public PlayerJoinAction(GamePlayer player) {
		this.player = player;
	}

	@Override
	public GamePlayer getPlayer() {
		return player;
	}
}
