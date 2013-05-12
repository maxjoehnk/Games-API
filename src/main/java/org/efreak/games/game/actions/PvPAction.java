package org.efreak.games.game.actions;

import org.efreak.games.GamePlayer;

public class PvPAction implements MultiPlayerAction {
	
	private GamePlayer[] players;
	
	public PvPAction(GamePlayer player1, GamePlayer player2) {
		players = new GamePlayer[2];
		players[0] = player1;
		players[1] = player2;
	}

	@Override
	public GamePlayer[] getPlayers() {
		return players;
	}
}
