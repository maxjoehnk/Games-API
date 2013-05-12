package org.efreak.games.game.actions;

import org.efreak.games.GamePlayer;

public interface MultiPlayerAction extends GameAction {
	
	public GamePlayer[] getPlayers();
	
}
