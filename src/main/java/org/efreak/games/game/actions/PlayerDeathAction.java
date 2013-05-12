package org.efreak.games.game.actions;

import org.efreak.games.GamePlayer;

public class PlayerDeathAction implements PlayerAction {

	private GamePlayer player;
	
	public PlayerDeathAction(GamePlayer player) {
		this.player = player;
	}

	@Override
	public GamePlayer getPlayer() {
		return player;
	}
}
