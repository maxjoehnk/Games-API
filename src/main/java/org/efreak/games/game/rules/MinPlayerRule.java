package org.efreak.games.game.rules;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.actions.GameAction;

public class MinPlayerRule extends GameRule {

	private int count;
	
	public MinPlayerRule(int count) {
		super("MinPlayerRule");
		this.count = count;
	}
	
	@Override
	public boolean isValid(GameInstance instance) {
		if (instance.getPlayers().size() < count) return false;
		else return true;
	}

	@Override
	public boolean isActionValid(GameInstance instance, GameAction action) {
		return true;
	}
	
}
