package org.efreak.games.game.rules;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.actions.GameAction;
import org.efreak.games.game.actions.PlayerRespawnAction;

public class RespawnRule extends GameRule {

	public RespawnRule() {
		super("RespawnRule");
	}

	private boolean respawnEnabled;
	
	@Override
	public boolean isValid(GameInstance instance) {
		return true;
	}

	@Override
	public boolean isActionValid(GameInstance instance, GameAction action) {
		if (action instanceof PlayerRespawnAction) return respawnEnabled;
		return true;
	}

}
