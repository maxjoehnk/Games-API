package org.efreak.games.game.actions;

import org.efreak.games.GamePlayer;
import org.efreak.games.game.PlayerClass;

public class ClassPickAction implements PlayerAction, PlayerClassAction {

	private GamePlayer player;
	private PlayerClass playerClass;
	
	public ClassPickAction(GamePlayer player, PlayerClass playerClass) {
		this.player = player;
		this.playerClass = playerClass;
	}
	
	@Override
	public PlayerClass getPlayerClass() {
		return playerClass;
	}

	@Override
	public GamePlayer getPlayer() {
		return player;
	}

}
