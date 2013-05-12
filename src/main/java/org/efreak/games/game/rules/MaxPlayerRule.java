package org.efreak.games.game.rules;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.actions.GameAction;
import org.efreak.games.game.actions.PlayerJoinAction;

public class MaxPlayerRule extends GameRule {

	private int count;
	
	public MaxPlayerRule(int count) {
		super("MaxPlayerRule");
		this.count = count;
	}
	
	@Override
	public boolean isValid(GameInstance instance) {
		if (instance.getPlayers().size() > count) return false;
		else return true;
	}

	@Override
	public boolean isActionValid(GameInstance instance, GameAction action) {
		if (action instanceof PlayerJoinAction) return instance.getPlayers().size() + 1 <= count;
		return true;
	}

	
	
}
