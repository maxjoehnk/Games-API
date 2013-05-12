package org.efreak.games.game.actions;

import org.efreak.games.GamePlayer;

public class PlayerLeaveAction implements PlayerAction {
	
	private GamePlayer player;
	
	public PlayerLeaveAction(GamePlayer player) {
		this.player = player;
	}

	@Override
	public GamePlayer getPlayer() {
		return player;
	}
}
