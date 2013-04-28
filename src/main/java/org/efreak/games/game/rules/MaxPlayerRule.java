package org.efreak.games.game.rules;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.actions.GameAction;

public class MaxPlayerRule implements GameRule {

	private int count;
	
	public MaxPlayerRule(int count) {
		this.count = count;
	}
	
	@Override
	public boolean isValid(GameInstance instance) {
		if (instance.getPlayers().size() > count) return false;
		else return true;
	}

	@Override
	public boolean isActionValid(GameInstance instance, GameAction action) {
		return false;
	}

	
	
}
